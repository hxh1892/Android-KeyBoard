package com.hxh.keyboard;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditTextActivity extends AppCompatActivity
{
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_et);

        final EditText et = findViewById(R.id.et_send);

        et.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                if (actionId == EditorInfo.IME_ACTION_SEND)
                {
                    //TODO:你自己的业务逻辑
                    //返回true，保留软键盘
                    //返回false，隐藏软键盘
                    Toast.makeText(mContext, "IME_ACTION_SEND:" + et.getText().toString(), Toast.LENGTH_SHORT).show();

                    return true;
                }

                return false;
            }
        });
    }


}
