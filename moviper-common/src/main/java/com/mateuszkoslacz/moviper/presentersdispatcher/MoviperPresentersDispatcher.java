package com.mateuszkoslacz.moviper.presentersdispatcher;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.util.SparseArray;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

import java.util.Random;

/**
 * Created by bwilk on 12/22/16.
 */
public class MoviperPresentersDispatcher {

    private static final String EXTRA_VIEW_ID = "EXTRA_VIEW_ID";
    private static MoviperPresentersDispatcher mInstance;
    private SparseArray<ViperPresenter> mPresenters = new SparseArray<>(); // TODO: 27.12.2016 SparseArray or HashMap?

    protected MoviperPresentersDispatcher() {
    }

    public static MoviperPresentersDispatcher getInstance() {
        if (mInstance == null) {
            mInstance = new MoviperPresentersDispatcher();
        }
        return mInstance;
    }

    @VisibleForTesting
    public static void setInstance(MoviperPresentersDispatcher mInstance) {
        MoviperPresentersDispatcher.mInstance = mInstance;
    }

    public ViperPresenter getPresenterForView(ViperView view) {
        return mPresenters.get(view.getArgs().getInt(EXTRA_VIEW_ID));
    }

    /**
     * It starts an {@link Activity} with selected presenter configured in a way provided in the
     * given {@link com.mateuszkoslacz.moviper.presentersdispatcher.ActivityStarter}.<p>
     *
     * Given {@link Activity} has to be passive (from package {@link com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive}),
     * and has to return value from {@link #getPresenterForView(ViperView)} method in {@link
     * MvpActivity#createPresenter()}.
     */
    public void startActivity(com.mateuszkoslacz.moviper.presentersdispatcher.ActivityStarter activityStarter) {
        int viewId = new Random().nextInt();
        activityStarter.getIntent().putExtra(EXTRA_VIEW_ID, viewId);
        mPresenters.put(viewId, activityStarter.getPresenter());
        activityStarter.getContext().startActivity(activityStarter.getIntent());
    }

    /**
     * It processes given {@link MvpFragment} to start with a given presenter. <p>
     *
     * Given {@link Fragment} has to be passive (from package {@link com.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive}),
     * and has to return value from {@link #getPresenterForView(ViperView)} method in {@link
     * MvpFragment#createPresenter()}.
     * <p>
     * The alternative way to achieve this is to set the fragment presenter like this:
     * <p><blockquote><pre>
     *   SomeViperFragment fragment = new SomeViperFragment();
     *   fragment.setPresenter(somePresenter);
     * </pre></blockquote><p>
     * and return the current presenter if it's not null inside fragment, in {@link
     * MvpFragment#createPresenter()}
     * <p><blockquote><pre>
     * public SomePresenter createPresenter() {
     *    if (presenter != null) return presenter;
     *    else return new SomePresenter();
     * }
     * </pre></blockquote><p>
     */
    public MvpFragment startFragment(MvpFragment fragment, ViperPresenter presenter) {
        int viewId = new Random().nextInt();
        Bundle arguments = fragment.getArguments();
        arguments.putInt(EXTRA_VIEW_ID, viewId);
        mPresenters.put(viewId, presenter);
        fragment.setArguments(arguments);
        return fragment;
    }

}
