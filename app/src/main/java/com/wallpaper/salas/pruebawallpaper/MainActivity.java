package com.wallpaper.salas.pruebawallpaper;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    public static int tipo=1;
    private RadioGroup rdgGrupo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(com.wallpaper.salas.pruebawallpaper.R.layout.activity_main);
        rdgGrupo = (RadioGroup)findViewById(R.id.rdgGrupo);
        rdgGrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.radioButton1){
                    tipo=0;
                }else if (checkedId == R.id.radioButton2){
                    tipo=1;
                }else if (checkedId == R.id.radioButton3){
                    tipo=2;
                }else if (checkedId == R.id.radioButton4){
                    tipo=3;
                }

            }

        });





    }


















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * react to the user tapping/selecting an options menu item
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_new_thingy:

                Intent i = new Intent(this, preferencias.class);
                startActivity(i);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




    }












