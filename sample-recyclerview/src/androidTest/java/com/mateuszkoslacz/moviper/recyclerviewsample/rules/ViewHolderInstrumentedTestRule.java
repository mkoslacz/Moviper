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
    private final int mViewId;
    private final M mModelObject;
    private MvpBaseViewHolder mViewHolder;

    private ViewHolderInstrumentedTestRule(Builder builder) {
        super(ViewHolderInstrumentedTestActivity.class, true, false);
        mViewHolderDelegate = builder.mViewHolderDelegate;
        mViewId = builder.mViewId;
        mModelObject = (M) builder.mModelObject;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    protected void afterActivityLaunched() {
        super.afterActivityLaunched();
        getActivity().runOnUiThread(() -> {
            getActivity().createViewHolderLayout(mViewId);
            mViewHolder = mViewHolderDelegate.getViewHolder(getActivity().getViewHolderLayout());
            mViewHolder.setDataObject(mModelObject);
            mViewHolder.bindPresenter();
        });
    }

    public interface ViewHolderDelegate {

        MvpBaseViewHolder getViewHolder(View view);
    }


    public static final class Builder<M> {

        private ViewHolderDelegate mViewHolderDelegate;
        private int mViewId;
        private M mModelObject;

        public Builder() {
        }

        public Builder withViewHolderDelegate(ViewHolderDelegate mViewHolderDelegate) {
            this.mViewHolderDelegate = mViewHolderDelegate;
            return this;
        }

        public Builder withViewId(int mViewId) {
            this.mViewId = mViewId;
            return this;
        }

        public Builder withModelObject(M mModelObject) {
            this.mModelObject = mModelObject;
            return this;
        }

        public ViewHolderInstrumentedTestRule build() {
            return new ViewHolderInstrumentedTestRule(this);
        }
    }
}
