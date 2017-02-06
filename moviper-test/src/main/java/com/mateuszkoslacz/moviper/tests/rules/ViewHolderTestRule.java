package com.mateuszkoslacz.moviper.tests.rules;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.mateuszkoslacz.moviper.base.view.viewholder.ViperViewHolder;
import com.mateuszkoslacz.moviper.tests.views.ViewHolderInstrumentedTestActivity;

/**
 * Created by tomasznajda on 05.12.2016.
 */

public class ViewHolderTestRule<M> extends ActivityTestRule<ViewHolderInstrumentedTestActivity> {

    private final ViewHolderDelegate mViewHolderDelegate;
    private final int mViewId;
    private final M mModelObject;
    private ViperViewHolder mViewHolder;

    private ViewHolderTestRule(Builder builder) {
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

        ViperViewHolder getViewHolder(View view);
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

        public ViewHolderTestRule build() {
            return new ViewHolderTestRule(this);
        }
    }
}
