package com.hxh.keyboard;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class LoginActivity3 extends AppCompatActivity implements KeyboardChangeListener.KeyBoardListener
{
    private KeyboardChangeListener mKeyboardChangeListener;

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);

        mKeyboardChangeListener = new KeyboardChangeListener(this);
        mKeyboardChangeListener.setKeyBoardListener(this);

        v = findViewById(R.id.v);
    }

    public void close(View v)
    {
        //关闭键盘
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        if (imm != null)
        {
            imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        }
    }

    @Override
    public void onKeyboardChange(boolean isShow, int keyboardHeight)
    {
        if (isShow)
        {
            Toast.makeText(this, "监听到软键盘弹起...", Toast.LENGTH_SHORT).show();

            v.setVisibility(View.GONE);
        }
        else
        {
            Toast.makeText(this, "监听到软健盘关闭...", Toast.LENGTH_SHORT).show();

            v.setVisibility(View.VISIBLE);
        }
    }
}
