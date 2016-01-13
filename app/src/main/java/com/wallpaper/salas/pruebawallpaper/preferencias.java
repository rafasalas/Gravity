package com.wallpaper.salas.pruebawallpaper;

/**
 * Created by salas on 07/01/2016.
 */
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

public class preferencias extends PreferenceActivity {
    public static final String PREFS="preferencias";
    public static final String PREFS_VALUE1="nivel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new preferenciasFragment()).commit();
    }

    public static class preferenciasFragment extends PreferenceFragment
    {
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
           addPreferencesFromResource(R.xml.preferencias);
        }
    }

}