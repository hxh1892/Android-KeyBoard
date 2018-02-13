package com.hxh.keyboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity3 extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);
    }

    public void login1(View v)
    {
        startActivity(new Intent(this, LoginActivity1.class));
    }

    public void login2(View v)
    {
        startActivity(new Intent(this, LoginActivity2.class));
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
