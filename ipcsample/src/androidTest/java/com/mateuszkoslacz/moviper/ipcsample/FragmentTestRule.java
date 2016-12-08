package com.mateuszkoslacz.moviper.ipcsample;

import android.os.Bundle;
import android.support.test.rule.ActivityTestRule;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.hannesdorfmann.mosby.mvp.MvpFragment;

import junit.framework.Assert;

/**
 * Created by bwilk on 12/5/16.
 */
public class FragmentTestRule<T extends MvpFragment> extends ActivityTestRule<TestActivity> {

    private final Class<T> mFragmentClass;
    private T mFragment;
    private FragmentManager mFragmentManager;
    private Bundle mArguments;

    public FragmentTestRule(final Class<T> fragmentClass) {
        super(TestActivity.class, true, false);
        mFragmentClass = fragmentClass;
    }

    public FragmentManager getFragmentManager() {
        return mFragmentManager;
    }

    @Override
    protected void afterActivityLaunched() {
        super.afterActivityLaunched();

        getActivity().runOnUiThread(() -> {
            try {
                mFragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = mFragmentManager.beginTransaction();
                mFragment = mFragmentClass.newInstance();
                mFragment.setArguments(mArguments != null ? mArguments : new Bundle());
                transaction.replace(R.id.container, mFragment);
                transaction.commit();
            } catch (InstantiationException | IllegalAccessException e) {
                Assert.fail(
                        String.format("%s: Could not insert %s into TestActivity: %s",
                                getClass().getSimpleName(),
                                mFragmentClass.getSimpleName(),
                                e.getMessage())
                );
            }
        });
    }

    public void setArguments(Bundle arguments) {
        mArguments = arguments;
    }

    public T getFragment() {
        return mFragment;
    }
}
