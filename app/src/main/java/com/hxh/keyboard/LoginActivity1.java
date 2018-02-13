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

public class LoginActivity1 extends AppCompatActivity implements View.OnLayoutChangeListener
{
    //Activity最外层的Layout视图
    private View v;
    private ScrollView sv;
    private TextView tv;
    private EditText et1, et2;

    //屏幕高度
    private int screenHeight = 0;
    //软件盘弹起后所占高度阀值
    private int keyHeight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        v = findViewById(R.id.v);
        sv = (ScrollView) findViewById(R.id.sv);
        tv = (TextView) findViewById(R.id.tv);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

        et1.setFocusable(false);
        et2.setFocusable(false);

        et1.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
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

        //获取屏幕高度
        screenHeight = this.getWindowManager().getDefaultDisplay().getHeight();
        //阀值设置为屏幕高度的1/4
        keyHeight = screenHeight / 4;
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
    protected void onResume()
    {
        super.onResume();

        //添加layout大小发生改变监听器
        v.addOnLayoutChangeListener(this);
    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right,
                               int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom)
    {
        //old是改变前的左上右下坐标点值，没有old的是改变后的左上右下坐标点值
//        System.out.println("oldLeft="+oldLeft + "-oldTop=" + oldTop +"-oldRight=" + oldRight + "-oldBottom=" + oldBottom);
//        System.out.println("left="+left + "-top=" + top +"-right=" + right + "-bottom=" + bottom);

        //现在认为只要控件将Activity向上推的高度超过了1/3屏幕高，就认为软键盘弹起
        if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > keyHeight))
        {
//            System.out.println("键盘弹起 oldLeft="+oldLeft + "-oldTop=" + oldTop +"-oldRight=" + oldRight + "-oldBottom=" + oldBottom);
//            System.out.println("键盘弹起 left="+left + "-top=" + top +"-right=" + right + "-bottom=" + bottom);

            Toast.makeText(LoginActivity1.this, "监听到软键盘弹起...", Toast.LENGTH_SHORT).show();

            tv.setVisibility(View.GONE);
            sv.fullScroll(ScrollView.FOCUS_DOWN);
        }
        else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom > keyHeight))
        {
//            System.out.println("健盘关闭 oldLeft="+oldLeft + "-oldTop=" + oldTop +"-oldRight=" + oldRight + "-oldBottom=" + oldBottom);
//            System.out.println("健盘关闭 left="+left + "-top=" + top +"-right=" + right + "-bottom=" + bottom);

            Toast.makeText(LoginActivity1.this, "监听到软健盘关闭...", Toast.LENGTH_SHORT).show();

            et1.setFocusable(false);
            et2.setFocusable(false);

            tv.setVisibility(View.VISIBLE);
            sv.fullScroll(ScrollView.FOCUS_UP);
        }
    }
}
