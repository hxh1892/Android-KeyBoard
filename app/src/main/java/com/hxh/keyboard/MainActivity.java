package com.hxh.keyboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login1(View v)
    {
        startActivity(new Intent(this, LoginActivity1.class));
    }

    public void login2(View v)
    {
        startActivity(new Intent(this, LoginActivity2.class));
    }

    public void login3(View v)
    {
        startActivity(new Intent(this, LoginActivity3.class));
    }

    public void dialog(View v)
    {
        startActivity(new Intent(this, DialogActivity.class));
    }

    public void message(View v)
    {
        startActivity(new Intent(this, MessageActivity.class));
    }
}
