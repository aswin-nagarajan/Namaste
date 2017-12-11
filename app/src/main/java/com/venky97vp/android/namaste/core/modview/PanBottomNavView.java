package com.venky97vp.android.namaste.core.modview;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.BottomNavigationView;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.MenuItem;

import com.venky97vp.android.namaste.core.customfont.CustomTypefaceSpan;


/**
 * Created by venky on 07-12-2017.
 */

public class PanBottomNavView extends BottomNavigationView {
    public PanBottomNavView(Context context) {
        super(context);
        setFont();
    }

    public PanBottomNavView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }

    public PanBottomNavView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont();
    }

    private void setFont() {
        Typeface mTypeface = Typeface.createFromAsset(getContext().getAssets(), "font/JosefinSans-Regular.ttf");
        CustomTypefaceSpan typefaceSpan = new CustomTypefaceSpan("", mTypeface);
        for (int i = 0; i < this.getMenu().size(); i++) {
            MenuItem menuItem = this.getMenu().getItem(i);
            SpannableStringBuilder spannableTitle = new SpannableStringBuilder(menuItem.getTitle());
            spannableTitle.setSpan(typefaceSpan, 0, spannableTitle.length(), 0);
            menuItem.setTitle(spannableTitle);
        }
    }
}
