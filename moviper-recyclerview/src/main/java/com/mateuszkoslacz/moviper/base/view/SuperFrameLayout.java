package com.mateuszkoslacz.moviper.base.view;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.widget.FrameLayout;


public class SuperFrameLayout extends FrameLayout {
    public SuperFrameLayout(@NonNull Context context) {
        super(context);
    }

    public SuperFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SuperFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(21)
    public SuperFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public Parcelable superOnSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    public void superOnRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(state);
    }

}
