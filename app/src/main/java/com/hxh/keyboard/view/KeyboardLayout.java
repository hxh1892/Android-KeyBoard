package com.hxh.keyboard.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

public class KeyboardLayout extends LinearLayout
{
    public static final int KEYBOARD_STATE_SHOW = -3;
    public static final int KEYBOARD_STATE_HIDE = -2;
    public static final int KEYBOARD_STATE_INIT = -1;

    private boolean mHasInit;
    private boolean mHasKeyBord;
    private int mHeight;

    public KeyboardLayout(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    public KeyboardLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public KeyboardLayout(Context context)
    {
        super(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b)
    {
        super.onLayout(changed, l, t, r, b);

        Log.i("KeyboardLayout", "changed=" + changed);
        Log.i("KeyboardLayout", "l=" + l + "-t=" + t + "-r=" + r + "-b=" + b);

        if (!mHasInit)
        {
            mHasInit = true;
            mHeight = b;

            if (mListener != null)
            {
                mListener.onKeyBoardStateChange(KEYBOARD_STATE_INIT);
            }
        }
        else
        {
            mHeight = Math.max(mHeight, b);
        }

        if (mHasInit && mHeight > b)
        {
            mHasKeyBord = true;

            if (mListener != null)
            {
                mListener.onKeyBoardStateChange(KEYBOARD_STATE_SHOW);
            }

            Log.i("KeyboardLayout", "show keyboard......." + changed);
        }

        if (mHasInit && mHasKeyBord && mHeight == b)
        {
            mHasKeyBord = false;

            if (mListener != null)
            {
                mListener.onKeyBoardStateChange(KEYBOARD_STATE_HIDE);
            }

            Log.i("KeyboardLayout", "hide keyboard......." + changed);
        }
    }

    private onKeyBordChangeListener mListener;

    public void setOnKeyBordStateListener(onKeyBordChangeListener listener)
    {
        mListener = listener;
    }

    public interface onKeyBordChangeListener
    {
        public void onKeyBoardStateChange(int state);
    }
}
