package com.venky97vp.android.namaste.core.modview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by venky on 06-12-2017.
 */

public class PanButton extends android.support.v7.widget.AppCompatButton {

    public PanButton(Context context) {
        super(context);
    }

    public PanButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PanButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTypeface(Typeface tf, int style) {
        tf = Typeface.createFromAsset(getContext().getAssets(), "font/JosefinSans-Regular.ttf");
        super.setTypeface(tf, style);
    }

    @Override
    public void setTypeface(Typeface tf) {
        tf = Typeface.createFromAsset(getContext().getAssets(), "font/JosefinSans-Regular.ttf");
        super.setTypeface(tf);
    }
}
