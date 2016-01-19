package com.wallpaper.salas.pruebawallpaper;




        import android.content.Context;
        import android.graphics.Canvas;
        import android.graphics.Color;
        import android.graphics.LinearGradient;
        import android.graphics.Paint;
        import android.graphics.RectF;
        import android.graphics.Path;
        import android.graphics.Paint.Style;
        import android.graphics.Shader;
        import android.graphics.Typeface;
        import android.view.View;

        import java.util.ArrayList;
        import java.util.Random;


        import processing.core.PVector;
/**
 * Created by salas on 20/11/2015.
 */

public class particula {

    PVector posicion, velocidad, aceleracion, gravedad;
    float limite;
    float masa;
    int lifespan;
    int r,g,b,a;
    int width, height;
    boolean eterna;
    int particle_class;
    Typeface nuevotipo;


    public particula(float orx,float ory, float vix, float viy, float masap, int red, int green, int blue, int alfa, int clase, Typeface type ){

        //this.contexto=contexto.getApplicationContext();
        //Typeface tipoduro=Typeface.createFromAsset(contexto.getApplicationContext().getAssets(), "fonts/Pacifico.ttf");
        Random rnd=new Random();
        //Random py=new Random();

        Random masaaleatoria=new Random();
        posicion=new PVector(orx,ory);
        //posicion=new PVector(5,5);
        velocidad=new PVector (vix, viy);
        //velocidad=new PVector (rnd.nextInt(10-5),rnd.nextInt(10-5));
        aceleracion=new PVector (0, 0);
        gravedad=new PVector (0, (float)0.02);
        limite=30;
        //masa=  masaaleatoria.nextInt(12-5);
        masa=masap;
       // a=rnd.nextInt(255);

        a=alfa;
        r=red;
        g=green;
        b=blue;
        eterna=false;
        lifespan=75;
        particle_class=clase;
        nuevotipo=type;

    }
    public boolean muerta(){if (lifespan<0){return true;}else {return false;}}
    public void acelerar(PVector fuerza){
        //PVector f = fuerza;
        PVector a=PVector.div(fuerza, masa);
       //f.div(masa / 4);
       // f.mult(masa);
        aceleracion.add(a);

    }

    public void cambiaparticula(int change){particle_class=change;}
   public void actualizar(int w, int h) {
        lifespan=lifespan-2;
        width=w;
        height=h;
        velocidad.add(aceleracion);

        velocidad.limit(limite);
        posicion.add(velocidad);



        aceleracion.mult(0);
            if (eterna) {
                if (posicion.x > width) {
                    velocidad.x = velocidad.x * -1;
                    posicion.x = width;
                }
                if (posicion.x < 0) {
                    velocidad.x = velocidad.x * -1;
                    posicion.x = 0;
                }
                if (posicion.y > height) {
                    velocidad.y = velocidad.y * -1;
                    posicion.y = height;
                }
                if (posicion.y < 0) {
                    velocidad.y = velocidad.y * -1;
                    posicion.y = 0;
                }
            }
    }

    public void mostrar(Canvas canvas){

                                 RectF limites;
                                Paint paint;


                                limites = new RectF();
                               float head=(float)Math.toDegrees(velocidad.heading());
                                 paint = new Paint();

                                if (eterna==false){a=lifespan;};
                                if (a<0 || a>255){a=0;}
                                paint.setARGB(a, r, g, b);
                                paint.setStyle(Style.FILL);
                                //paint.setStrokeWidth(10);
                               // Typeface type=Typeface.createFromFile("@fonts/Jura-Regular.ttf");

                                paint.setTypeface(nuevotipo);
                                paint.setAntiAlias(true);
        switch(particle_class) {
            case 0:
                limites.set(posicion.x, posicion.y, posicion.x + masa * 2, posicion.y + masa * 2);
                canvas.drawOval(limites, paint);
                break;
            case 1:
                canvas.save();
                canvas.translate(posicion.x, posicion.y);
                canvas.rotate(head, 0, 0);
                limites.set(0, 0, masa * 5, masa);
                canvas.drawRect(limites, paint);
                canvas.restore();
                break;
            case 2:
                canvas.save();
                canvas.translate(posicion.x, posicion.y);
                canvas.rotate(head, 0, 0);
                limites.set(0, 0, masa *2, masa*2);
                canvas.drawRect(limites, paint);
                canvas.restore();
                break;
            case 3:
                canvas.save();
                canvas.translate(posicion.x, posicion.y);
                canvas.rotate(head, 0, 0);
                paint.setTextSize(masa*5);
                canvas.drawText("My Text", 0,0, paint);
                canvas.restore();
                break;
        }
                                }

}
