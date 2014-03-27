package com.jordan.location.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load();
    }

    private void load() {
//        Button btnPortugues = (Button) findViewById(R.id.btnPortugues);
//        Button btnIngles = (Button) findViewById(R.id.btnIngles);
//        Button btnEspanhol = (Button) findViewById(R.id.btnEspanhol);
    }

    public void onClickPortugues(View view) {
        changeLanguageSettings(this, new Locale("pt", "BR"));
    }

    public void onClickIngles(View view) {
        changeLanguageSettings(this, Locale.ENGLISH);
    }

    public void onClickEspanhol(View view) {
        changeLanguageSettings(this, new Locale("es", "ES"));
    }

    public void setLocale(String lang) {
//        Locale myLocale = new Locale(lang);
//        Resources res = getResources();
//        DisplayMetrics dm = res.getDisplayMetrics();
//        Configuration conf = res.getConfiguration();
//        conf.locale = myLocale;
//        res.updateConfiguration(conf, dm);
//        Intent refresh = new Intent(this, AndroidLocalize.class);
//        startActivity(refresh);
    }

    public void changeLanguageSettings(Context con, Locale language) {
        try {
            /** here add language code */
            Locale locale = language;

            Class amnClass = Class.forName("android.app.ActivityManagerNative");
            Object amn = null;
            Configuration config = null;

            // amn = ActivityManagerNative.getDefault();
            Method methodGetDefault = amnClass.getMethod("getDefault");
            methodGetDefault.setAccessible(true);
            amn = methodGetDefault.invoke(amnClass);

            // config = amn.getConfiguration();
            Method methodGetConfiguration = amnClass
                    .getMethod("getConfiguration");
            methodGetConfiguration.setAccessible(true);
            config = (Configuration) methodGetConfiguration.invoke(amn);

            // config.userSetLocale = true;
            Class configClass = config.getClass();
            Field f = configClass.getField("userSetLocale");
            f.setBoolean(config, true);

            // set the locale to the new value
            config.locale = locale;

            // amn.updateConfiguration(config);
            Method methodUpdateConfiguration = amnClass.getMethod(
                    "updateConfiguration", Configuration.class);
            methodUpdateConfiguration.setAccessible(true);
            methodUpdateConfiguration.invoke(amn, config);

        } catch (Exception e) {
            // TODO: handle exception
            Log.d("error lang change-->", "" + e.getMessage().toString());
        }
    }
}