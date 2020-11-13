package com.hxh.keyboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.hxh.keyboard.utils.KeyboardChangeListener;

public class MessageActivity extends AppCompatActivity implements KeyboardChangeListener.KeyBoardListener
{
    private KeyboardChangeListener mKeyboardChangeListener;

    private EditText et;
    private ScrollView sv;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        mKeyboardChangeListener = new KeyboardChangeListener(this);
        mKeyboardChangeListener.setKeyBoardListener(this);

        Toolbar tb = findViewById(R.id.tb);

        tb.setTitle("title");

        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tb.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        et = findViewById(R.id.et);
        sv = findViewById(R.id.sv);

        et.setFocusable(false);

        et.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                et.setFocusable(true);//设置输入框可聚集
                et.setFocusableInTouchMode(true);//设置触摸聚焦
                et.requestFocus();//请求焦点
                et.findFocus();//获取焦点

                return false;
            }
        });

        sv.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if (et.isFocused())
                {
                    //关闭键盘
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

                    if (imm != null)
                    {
                        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                    }
                }

                return false;
            }
        });
    }

    @Override
    public void onKeyboardChange(boolean isShow, int keyboardHeight)
    {
        if (isShow)
        {
            Toast.makeText(MessageActivity.this, "监听到软键盘弹起...", Toast.LENGTH_SHORT).show();

            sv.fullScroll(ScrollView.FOCUS_DOWN);
        }
        else
        {
            Toast.makeText(MessageActivity.this, "监听到软健盘关闭...", Toast.LENGTH_SHORT).show();

            et.setFocusable(false);

            sv.fullScroll(ScrollView.FOCUS_DOWN);
        }
    }
}