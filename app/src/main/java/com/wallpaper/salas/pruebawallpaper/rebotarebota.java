package com.wallpaper.salas.pruebawallpaper;

/**
 * Created by salas on 14/12/2015.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Path;
import android.graphics.Paint.Style;
import android.view.Display;
import android.view.WindowManager;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import processing.core.PVector;

import static android.opengl.ETC1.getHeight;
import static android.opengl.ETC1.getWidth;

/**
 * Created by salas on 20/11/2015.
 */
public class rebotarebota{
    //variables
    int x,y;
    int minute;
    private RectF limites;
    private Paint paint;
    private Path linea;

    private int sec, min, hor;
    private sistema man_sec, man_min, man_hor;
    private int oldsec;

    private float longitud, longitud_hora;
    private double ang_sec, ang_min, ang_hor;
    float repulsion=0;
    public rebotarebota(){


        //super(context);
        y=0;
        x=0;
        oldsec=0;
        limites = new RectF();
        paint = new Paint();

        linea = new Path();

       // width = w;
        //height = (int) (0.9 * h);
        man_sec=new sistema();
        man_min=new sistema();
        man_hor=new sistema();
        man_sec.colorea_particulas(254, 254, 254);
        man_sec.engorda_particulas(5,5);
        man_min.colorea_particulas(254, 254, 254);
        man_min.engorda_particulas(8,12);
        man_hor.colorea_particulas(254, 0, 0);
        man_hor.engorda_particulas(8, 12);
        //for (int i = 0; i <500; i++) {nubecilla.otraparticula();}

    }
    public void cambiarepulsion(int r){repulsion=(float)r;}

    public void draw(Canvas canvas,int width, int height){


        longitud=(width/5)*1.8f;
        longitud_hora=(width/5);


        man_sec.origen=new PVector(0,longitud);
        man_min.origen=new PVector(0,longitud);
        man_hor.origen=new PVector(0,longitud_hora);


        sec = Calendar.getInstance().get(Calendar.SECOND);
        min = Calendar.getInstance().get(Calendar.MINUTE);
        hor = Calendar.getInstance().get(Calendar.HOUR);
        ang_sec=(6 * sec)-180;
        ang_min=((6)*min)-180;
        ang_hor=((((30)*hor+(.5)*min)))-180;


        man_sec.otraparticula();
        man_min.otraparticula();
        man_hor.otraparticula();
        canvas.drawColor(0xFF000000);
        //canvas.drawPaint(black);
    canvas.save();
        canvas.translate(width / 2, height / 2);
        canvas.save();

        canvas.rotate((float) ang_sec);

        man_sec.dibujaparticulas(canvas);
        canvas.restore();

        canvas.save();
        canvas.rotate((float) ang_min);
        //canvas.translate(width / 2, height / 2);
        man_min.dibujaparticulas(canvas);
        canvas.restore();


        canvas.save();
        canvas.rotate((float) ang_hor);
        //canvas.translate(width / 2, height / 2);
        man_hor.dibujaparticulas(canvas);

        canvas.restore();

    canvas.restore();
        update(width, height);

    }

    public void update(int w, int h){
        Random rnd=new Random();
        int signo;

        float repulse=8.0f;



        if (sec!=oldsec){repulse=-85.0f;oldsec=sec;}else{repulse=12.0f;}
        //if (sec!=oldsec){repulse=-repulsion;oldsec=sec;}else{repulse=2.0f;}


        // nubecilla.acelera_particulas(gravity);

        //segundos
        man_sec.velocidadinicial.x=(rnd.nextFloat())*5;
        man_sec.velocidadinicial.y=(rnd.nextFloat())*5;

        man_sec.central(0,0, repulse);

        man_sec.actualiza_particula(w, h);

        //min
        man_min.velocidadinicial.x=(rnd.nextFloat())*5;
        man_min.velocidadinicial.y=-(rnd.nextFloat())*5;

        man_min.central(0,0, repulse);

        man_min.actualiza_particula(w,h);

        //horas
        man_hor.velocidadinicial.x=(rnd.nextFloat())*5;
        man_hor.velocidadinicial.y=-(rnd.nextFloat())*5;

        man_hor.central(0,0, repulse);

        man_hor.actualiza_particula(w, h);


    }




}
