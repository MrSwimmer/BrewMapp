package com.brewmapp.brewmapp.core.presentation.custom.widget_plus;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.design.widget.TextInputEditText;
import android.util.AttributeSet;

import com.brewmapp.brewmapp.R;


public class TextInputEditTextPlus extends TextInputEditText {
    public TextInputEditTextPlus(Context context) {
        super(context);
    }

    public TextInputEditTextPlus(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public TextInputEditTextPlus(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomFont(context, attrs);
    }

    private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.TextViewPlus);
        String customFont = a.getString(R.styleable.TextViewPlus_customFont);
        setCustomFont(ctx);
        a.recycle();
    }

    public boolean setCustomFont(Context ctx) {
        String font = "main.otf";
        Typeface CF = Typeface.createFromAsset(ctx.getAssets(), font);
        setTypeface(CF);
        getBackground().mutate().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        return true;
    }
}
