package com.virtualcode7ecuadorvigitrack.auditorioespoch.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.virtualcode7ecuadorvigitrack.auditorioespoch.R;
import com.virtualcode7ecuadorvigitrack.auditorioespoch.utils.cToolbar;

public class InicioActivity extends AppCompatActivity
{

    private Toolbar mToolbar;
    private MaterialButton materialButtonVideo;
    private MaterialButton materialButtonGraduate;
    private MaterialButton materialButtonLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        new cToolbar()
                .showToolbar(InicioActivity.this,mToolbar,"",1,true);

        materialButtonVideo = findViewById(R.id.id_btn_comenzar_video);
        materialButtonGraduate = findViewById(R.id.id_btn_graduacion);
        materialButtonLogo = findViewById(R.id.id_btn_comenzar_logo);
        materialButtonLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent mIntent = new Intent(InicioActivity.this,LogoActivity.class);
                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mIntent);
            }
        });
        materialButtonVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent mIntent = new Intent(InicioActivity.this,VideoActivity.class);
                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mIntent);
            }
        });
        materialButtonGraduate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent mIntent = new Intent(InicioActivity.this,GraduateActivity.class);
                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mIntent);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}