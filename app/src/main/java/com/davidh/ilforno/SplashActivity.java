package com.davidh.ilforno;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    String datos;

    private static final long delay =3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);




        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                datos = prefs.getString("Usuario", "nada");

                if (datos.equals("nada")){

                    Intent i = new Intent().setClass(SplashActivity.this,LogginActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Intent i = new Intent().setClass(SplashActivity.this,MainActivity.class);
                    startActivity(i);
                    finish();

                }

            }
        };

        Timer timer=new Timer();
        timer.schedule(task,delay);


    }
}
