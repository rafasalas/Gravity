package com.wallpaper.salas.pruebawallpaper;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Path;
import android.graphics.Paint.Style;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

import processing.core.PVector;
/**
 * Created by salas on 20/11/2015.
 */
public class sistema {
                    PVector origen, velocidadinicial, Vvar;
                    float masaparticula;
                    ArrayList<particula> particulas;
                    int a,r,g,b;
                    sistema (){
                        Random rnd=new Random();
                        particulas = new ArrayList<particula>();
                        origen=new PVector (rnd.nextInt(10-5),rnd.nextInt(10-5));
                        velocidadinicial=new PVector (0,rnd.nextInt(10-5));
                        masaparticula=rnd.nextFloat()*15;
                        a=rnd.nextInt(255);
                        r=rnd.nextInt(255);
                        g=rnd.nextInt(255);
                        b=rnd.nextInt(255);
                         }
                    public void otraparticula()
                                                                {Random rnd=new Random();
                                                                    //a=rnd.nextInt(255-125);
                                                                    float masaparticula1=rnd.nextFloat()*masaparticula;
                                                                   // particulas.add(new particula(origen.x,origen.y, velocidadinicial.x, velocidadinicial.y,masaparticula,r, g, b,a ));
                                                                    particulas.add(new particula(origen.x,origen.y, velocidadinicial.x, velocidadinicial.y,masaparticula1,r, g, b,a));
                                                                    float masaparticula2=rnd.nextFloat()*masaparticula;
                                                                    particulas.add(new particula(origen.x,origen.y, velocidadinicial.x, velocidadinicial.y,masaparticula2,r, g, b,a));
                                                                }
                    public void colorea_particulas(int red, int green, int blue){
                       r=red;
                        g=green;
                        b=blue;


                        }
    public void engorda_particulas(int max, int min){
                                Random rnd=new Random();

                            //masaparticula=rnd.nextInt(12-10);;
                            masaparticula=max;
                            }

                    public void dibujaparticulas(Canvas canvas){

                                                for (int i = 0; i < particulas.size(); i++) {
                                                particula p = particulas.get(i);
                                                p.mostrar(canvas);
                                                if (p.muerta()){particulas.remove(i);}

                                                }

                                                }



                    public void acelera_particulas(PVector fuerza){

                        for (int i = 0; i < particulas.size(); i++) {
                            particula p = particulas.get(i);
                            p.acelerar(fuerza);}

                    }
                    public void actualiza_particula(int w, int h) {
                            for (int i = 0; i < particulas.size(); i++) {
                                particula p = particulas.get(i);
                                p.actualizar(w, h);}

                        }
                    public void central(int x, int y, float intensidad){
                        PVector centro;

                        for (int i = 0; i < particulas.size(); i++) {
                            particula p = particulas.get(i);
                            centro=new PVector (x, y);
                            PVector rayo=centro;
                            rayo.sub(p.posicion);
                            //float magnitud=rayo.mag();

                            //rayo.normalize();
                            //rayo.mult(150/intensidad);
                            rayo.div(intensidad);

                            //rayo.mult(-1);
                            p.acelerar(rayo);

                                    }

                    }
    public void cambiasistema(int cambio){
        for (int i = 0; i < particulas.size(); i++) {
            particula p = particulas.get(i);
            p.cambiaparticula(cambio);


        }

    }

}
