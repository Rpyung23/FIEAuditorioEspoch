package com.virtualcode7ecuadorvigitrack.auditorioespoch.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.virtualcode7ecuadorvigitrack.auditorioespoch.R;

public class WelcomeActivity extends AppCompatActivity
{
    private Button mButtonInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mButtonInicio = findViewById(R.id.id_btn_empecemos);
        mButtonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent mIntent = new Intent(WelcomeActivity.this,InicioActivity.class);
                mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mIntent);
                finish();
            }
        });
    }
}