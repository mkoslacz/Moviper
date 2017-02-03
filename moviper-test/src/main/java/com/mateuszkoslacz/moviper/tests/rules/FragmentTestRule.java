package com.mateuszkoslacz.moviper.tests.rules;

import android.os.Bundle;
import android.support.test.rule.ActivityTestRule;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.mateuszkoslacz.moviper.R;
import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter;
import com.mateuszkoslacz.moviper.presenterbus.Moviper;
import com.mateuszkoslacz.moviper.tests.views.TestActivity;

import junit.framework.Assert;

/**
 * Created by bwilk on 12/5/16.
 *
 * REMEMBER TO ADD moviper-test MODULE TO YOUR GRADLE FILE USING debugCompile, NOT testCompile TO MAKE
 * IT WORK!
 */
public class FragmentTestRule<FragmentType extends Fragment> extends ActivityTestRule<TestActivity> {

    private final Class<FragmentType> mFragmentClass;
    private FragmentType mFragment;
    private FragmentManager mFragmentManager;
    private Bundle mArguments;
    private boolean mIsFragmentRemoved;

    public FragmentTestRule(final Class<FragmentType> fragmentClass) {
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
            } catch (InstantiationException e) {
                Assert.fail(
                        String.format("%s: Could not insert %s into TestActivity: %s",
                                getClass().getSimpleName(),
                                mFragmentClass.getSimpleName(),
                                e.getMessage())
                );
            } catch (IllegalAccessException e) {
                Assert.fail(
                        String.format("%s: Could not insert %s into TestActivity: %s",
                                getClass().getSimpleName(),
                                mFragmentClass.getSimpleName(),
                                e.getMessage())
                );
            }
        });
    }

    @Override
    protected void afterActivityFinished() {
        super.afterActivityFinished();
        Moviper.getInstance().getPresenters(BaseRxPresenter.class)
                .subscribe(Moviper.getInstance()::unregister);
    }

    public void removeFragment() {
        getActivity().runOnUiThread(() -> {
            if (!mIsFragmentRemoved) {
                mFragmentManager.beginTransaction()
                        .remove(mFragment)
                        .commit();
                mIsFragmentRemoved = true;
            }
        });
    }

    public void setArguments(Bundle arguments) {
        mArguments = arguments;
    }

    public FragmentType getFragment() {
        return mFragment;
    }
}
