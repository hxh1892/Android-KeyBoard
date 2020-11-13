package com.hxh.keyboard;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class DialogActivity extends AppCompatActivity
{
    private Context mContext = this;
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        et = (EditText) findViewById(R.id.et);
    }

    public void show(View v)
    {
        //弹出键盘
        et.setFocusable(true);
        et.setFocusableInTouchMode(true);
        et.requestFocus();

        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);

        if (imm != null)
        {
            imm.showSoftInput(et, 0);
        }
    }

    public void close(View v)
    {
        //关闭键盘
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        if (imm != null)
        {
            imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        }

//        View view = getCurrentFocus();
//
//        if (view != null)
//        {
//            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
//                    hideSoftInputFromWindow(view.getWindowToken(), 0);
//        }
    }

    public void show_c(View v)
    {
        final BottomSheetDialog dialog = new BottomSheetDialog(mContext);
//        final Dialog dialog = new Dialog(mContext, R.style.FullscreenDialogTheme);
        dialog.setContentView(R.layout.dia_comment);

        final EditText et = (EditText) dialog.findViewById(R.id.et);

        //BottomSheetDialog专用
        dialog.setOnShowListener(new DialogInterface.OnShowListener()
        {
            @Override
            public void onShow(DialogInterface dialog)
            {
                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        //弹出键盘
                        et.setFocusable(true);
                        et.setFocusableInTouchMode(true);
                        et.requestFocus();

                        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);

                        if (imm != null)
                        {
                            imm.showSoftInput(et, 0);
                        }
                    }
                }, 30);
            }
        });

        dialog.findViewById(R.id.ll).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.tv).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(mContext, "评论：" + et.getText().toString(), Toast.LENGTH_SHORT).show();

                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
