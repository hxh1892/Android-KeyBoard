package com.hxh.keyboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

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

    public void login4(View v)
    {
        startActivity(new Intent(this, LoginActivity4.class));
    }

    public void dialog(View v)
    {
        startActivity(new Intent(this, DialogActivity.class));
    }

    public void message(View v)
    {
        startActivity(new Intent(this, MessageActivity.class));
    }

    public void edittext(View v)
    {
        startActivity(new Intent(this, EditTextActivity.class));
    }

    public void layout(View v)
    {
        startActivity(new Intent(this, LayoutActivity.class));
    }
}
