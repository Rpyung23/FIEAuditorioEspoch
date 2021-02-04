package com.virtualcode7ecuadorvigitrack.auditorioespoch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.virtualcode7ecuadorvigitrack.auditorioespoch.views.InicioActivity;
import com.virtualcode7ecuadorvigitrack.auditorioespoch.views.WelcomeActivity;

public class SplashScreenActivity extends AppCompatActivity {
    private Handler mHandler = new Handler();
    private Runnable mRunnable= new Runnable() {
        @Override
        public void run()
        {
            Intent mIntent = new Intent(SplashScreenActivity.this, WelcomeActivity.class);
            mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(mIntent);
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mHandler.postDelayed(mRunnable,3000);
    }
}