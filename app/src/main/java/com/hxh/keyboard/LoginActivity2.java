package com.hxh.keyboard;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity2 extends AppCompatActivity implements KeyboardChangeListener.KeyBoardListener
{
    private KeyboardChangeListener mKeyboardChangeListener;

    private EditText et1, et2;
    private ScrollView sv;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        mKeyboardChangeListener = new KeyboardChangeListener(this);
        mKeyboardChangeListener.setKeyBoardListener(this);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        sv = (ScrollView) findViewById(R.id.sv);
        tv = (TextView) findViewById(R.id.tv);

        et1.setFocusable(false);
        et2.setFocusable(false);

        et1.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                et2.setFocusable(false);

                et1.setFocusable(true);//设置输入框可聚集
                et1.setFocusableInTouchMode(true);//设置触摸聚焦
                et1.requestFocus();//请求焦点
                et1.findFocus();//获取焦点

                return false;
            }
        });

        et2.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                et1.setFocusable(false);

                et2.setFocusable(true);//设置输入框可聚集
                et2.setFocusableInTouchMode(true);//设置触摸聚焦
                et2.requestFocus();//请求焦点
                et2.findFocus();//获取焦点

                return false;
            }
        });

        sv.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                //不能滑动
                return true;
                //可以滑动
//                return false;
            }
        });
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
            Toast.makeText(LoginActivity2.this, "监听到软键盘弹起...", Toast.LENGTH_SHORT).show();

            tv.setVisibility(View.GONE);
            sv.fullScroll(ScrollView.FOCUS_DOWN);
        }
        else
        {
            Toast.makeText(LoginActivity2.this, "监听到软健盘关闭...", Toast.LENGTH_SHORT).show();

            et1.setFocusable(false);
            et2.setFocusable(false);

            tv.setVisibility(View.VISIBLE);
            sv.fullScroll(ScrollView.FOCUS_UP);
        }
    }
}