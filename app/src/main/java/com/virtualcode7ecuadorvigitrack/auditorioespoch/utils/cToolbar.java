package com.virtualcode7ecuadorvigitrack.auditorioespoch.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.virtualcode7ecuadorvigitrack.auditorioespoch.R;

public class cToolbar
{
    public static void  showToolbar(AppCompatActivity mAppCompatActivity,
                                    Toolbar mToolbar,String title,int type,boolean back)
    {
        switch (type)
        {
            case 1:
                mToolbar = mAppCompatActivity.findViewById(R.id.id_toolbar_color);
                break;
        }

        mAppCompatActivity.setSupportActionBar(mToolbar);
        mAppCompatActivity.getSupportActionBar().setTitle(title);
        mAppCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(back);
        mToolbar.setNavigationIcon(R.drawable.rehacer);
        //mAppCompatActivity.getSupportActionBar().setIcon(R.drawable.rehacer);
    }
}
