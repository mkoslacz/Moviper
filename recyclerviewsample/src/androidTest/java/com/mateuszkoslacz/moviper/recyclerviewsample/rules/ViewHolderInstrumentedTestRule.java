package com.mateuszkoslacz.moviper.recyclerviewsample.rules;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.mateuszkoslacz.moviper.base.view.MvpBaseViewHolder;
import com.mateuszkoslacz.moviper.recyclerviewsample.utils.ViewHolderInstrumentedTestActivity;

/**
 * Created by tomasznajda on 05.12.2016.
 */

public class ViewHolderInstrumentedTestRule<M> extends ActivityTestRule<ViewHolderInstrumentedTestActivity> {

    private final ViewHolderDelegate mViewHolderDelegate;
    private final ViewDelegate mViewDelegate;
    private final ModelDelegate<M> mModelDelegate;
    private MvpBaseViewHolder mViewHolder;

    public ViewHolderInstrumentedTestRule(final ViewDelegate viewDelegate,
                                          final ViewHolderDelegate viewHolderDelegate,
                                          final ModelDelegate<M> modelDelegate) {
        super(ViewHolderInstrumentedTestActivity.class, true, false);
        mViewDelegate = viewDelegate;
        mViewHolderDelegate = viewHolderDelegate;
        mModelDelegate = modelDelegate;
    }

    @Override
    protected void afterActivityLaunched() {
        super.afterActivityLaunched();
        getActivity().runOnUiThread(() -> {
            getActivity().addViewHolderView(mViewDelegate.getViewId());
            mViewHolder = mViewHolderDelegate.getViewHolder(getActivity().getViewHolderView());
            mViewHolder.setDataObject(mModelDelegate.getModel());
            mViewHolder.bindPresenter();
        });
    }

    public View getViewHolderView() {
        return getActivity().getViewHolderView();
    }

    public interface ViewHolderDelegate {

        MvpBaseViewHolder getViewHolder(View view);
    }

    public interface ViewDelegate {

        int getViewId();
    }

    public interface ModelDelegate<M> {

        M getModel();
    }
}
