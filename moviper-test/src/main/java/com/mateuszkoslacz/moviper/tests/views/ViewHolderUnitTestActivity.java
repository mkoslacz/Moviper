package com.mateuszkoslacz.moviper.tests.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.mateuszkoslacz.moviper.tests.R;


/**
 * Created by tomasznajda on 05.12.2016.
 */
@VisibleForTesting
public class ViewHolderUnitTestActivity extends AppCompatActivity {

    private FrameLayout mRootView;
    private View mViewHolderView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRootView = new FrameLayout(this);
        mRootView.setId(R.id.container);
        setContentView(mRootView);
    }

    public void createViewHolderLayout(int viewId) {
        mViewHolderView = LayoutInflater.from(this).inflate(viewId, null);
        mRootView.removeAllViews();
        mRootView.addView(mViewHolderView);
    }

    public View getViewHolderLayout() {
        return mViewHolderView;
    }
}
