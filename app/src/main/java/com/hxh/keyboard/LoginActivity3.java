package com.hxh.keyboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hxh.keyboard.utils.KeyboardChangeListener;
import com.hxh.keyboard.view.KeyboardLayout;

import static com.hxh.keyboard.view.KeyboardLayout.KEYBOARD_STATE_HIDE;
import static com.hxh.keyboard.view.KeyboardLayout.KEYBOARD_STATE_SHOW;

public class LoginActivity3 extends AppCompatActivity
{
    private EditText et1, et2;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

        KeyboardLayout kbl = findViewById(R.id.kbl);

        kbl.setOnKeyBordStateListener(new KeyboardLayout.onKeyBordChangeListener()
        {
            @Override
            public void onKeyBoardStateChange(int state)
            {
                if (state == KEYBOARD_STATE_SHOW)
                {
                    Toast.makeText(LoginActivity3.this, "软键盘出现", Toast.LENGTH_SHORT).show();
                }
                else if (state == KEYBOARD_STATE_HIDE )
                {
                    Toast.makeText(LoginActivity3.this, "软键盘隐藏", Toast.LENGTH_SHORT).show();

                    et1.clearFocus();
                    et2.clearFocus();
                }
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
}