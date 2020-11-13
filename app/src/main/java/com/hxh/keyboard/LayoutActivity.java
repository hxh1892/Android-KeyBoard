package com.hxh.keyboard;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hxh.keyboard.view.KeyboardLayout;

import static com.hxh.keyboard.view.KeyboardLayout.KEYBOARD_STATE_HIDE;
import static com.hxh.keyboard.view.KeyboardLayout.KEYBOARD_STATE_SHOW;

public class LayoutActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        KeyboardLayout kbl = findViewById(R.id.kbl);

        kbl.setOnKeyBordStateListener(new KeyboardLayout.onKeyBordChangeListener()
        {
            @Override
            public void onKeyBoardStateChange(int state)
            {
                if (state == KEYBOARD_STATE_SHOW)
                {
                    Toast.makeText(LayoutActivity.this, "软键盘出现", Toast.LENGTH_SHORT).show();
                }
                else if (state == KEYBOARD_STATE_HIDE)
                {
                    Toast.makeText(LayoutActivity.this, "软键盘隐藏", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
