package com.wallpaper.salas.pruebawallpaper;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.Typeface;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.preference.Preference;
import android.service.wallpaper.WallpaperService;
import android.util.Log;
import android.view.SurfaceHolder;
import java.io.IOException;
//import java.util.logging.Handler;
import android.os.Handler;

public class wallpaper extends WallpaperService {

    @Override
    public Engine onCreateEngine() {

        return new wallpaperEngine();
    }


    private class wallpaperEngine extends Engine {

        private final int frameDuration = 16;
        private SurfaceHolder holder;

        private boolean visible;
        private Handler handler;
        private rebotarebota rebota;
        private wallpaperEngine() {
            Typeface tipoduro= Typeface.createFromAsset(getAssets(), "fonts/Pacifico.ttf");
           rebota=new rebotarebota(MainActivity.tipo, tipoduro);
            handler = new Handler();
        }

        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {


            super.onCreate(surfaceHolder);

            this.holder = surfaceHolder;
        }

        private Runnable drawGif = new Runnable() {
            @Override
            public void run() {
                draw();

            }
        }
            ;

            private void draw() {

                SharedPreferences mySharedPreferences = getApplicationContext().getSharedPreferences(preferencias.PREFS, Activity.MODE_PRIVATE);

                int valor = Integer.valueOf(mySharedPreferences.getString(preferencias.PREFS_VALUE1, "7"));
                Log.d("me cago en ", String.valueOf(valor) );
                rebota.cambiarepulsion(valor);
                if (visible) {
                    Canvas canvas = holder.lockCanvas();
                    canvas.save();
                    int width=canvas.getWidth();
                    int height=canvas.getHeight();
                    rebota.draw(canvas, width, height);
                    canvas.restore();
                    holder.unlockCanvasAndPost(canvas);

                    handler.removeCallbacks(drawGif);
                    handler.postDelayed(drawGif, frameDuration);
                }
            }

            public void onVisibilityChanged(boolean visible) {
                this.visible = visible;

                if (visible) {
                    handler.post(drawGif);
                } else {
                    handler.removeCallbacks(drawGif);
                }

            }


            @Override
            public void onDestroy() {

                super.onDestroy();
                handler.removeCallbacks(drawGif);
            }
        }

    }
