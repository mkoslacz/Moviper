package com.mateuszkoslacz.moviper.sample.viper.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;
import com.mateuszkoslacz.moviper.sample.R;
import com.mateuszkoslacz.moviper.sample.viper.contract.LoginContract;
import com.mateuszkoslacz.moviper.sample.viper.presenter.LoginPresenter;
import com.mateuszkoslacz.moviper.sample.viper.view.fragment.iface.AuthorizationFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mateuszkoslacz on 25.07.2016.
 * <p>
 * Sample of Mosby LCE management. See {@link RegisterFragment} to check out custom LCE management.
 */
// TODO blocking touch ui on loading
public class LoginFragment extends MvpLceFragment<FrameLayout, Object, LoginContract.View, LoginContract.Presenter>
        implements AuthorizationFragment, LoginContract.View, LoginContract.ViewHelper {

    @BindView(R.id.fragment_authorization_login_edittext_login)
    EditText mLoginEditText;
    @BindView(R.id.fragment_authorization_login_edittext_password)
    EditText mPasswordEditText;
    @BindView(R.id.loading_logo)
    ImageView loadingLogo;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    // I DO NOT encourage block comments in non-sample code! Organize your code
    // in the self-explaining way and block comments will become redundant.
    ///////////////////////////////////////////////////////////////////////////
    // initializer
    ///////////////////////////////////////////////////////////////////////////

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater,
                                          @Nullable ViewGroup container,
                                          @Nullable Bundle savedInstanceState) {
        android.view.View view = inflater.inflate(
                R.layout.fragment_authorization_login,
                container,
                false);
        ButterKnife.bind(this, view);
        return view;
    }


    ///////////////////////////////////////////////////////////////////////////
    // events handling - propagating UI events to the Presenter
    ///////////////////////////////////////////////////////////////////////////

    @OnClick(R.id.fragment_authorization_login_btn_show_register)
    void onGotoRegisterButtonClick() {
        presenter.onShowRegisterFragmentClicked();
    }

    @OnClick(R.id.fragment_authorization_login_btn_login)
    void onLoginButtonClick() {
        presenter.onLoginClicked(mLoginEditText.getText().toString(),
                mPasswordEditText.getText().toString());
    }


    ///////////////////////////////////////////////////////////////////////////
    // creating the Presenter
    ///////////////////////////////////////////////////////////////////////////

    @NonNull
    @Override
    public LoginContract.Presenter createPresenter() {
        return new LoginPresenter(this);
    }


    ///////////////////////////////////////////////////////////////////////////
    // ViewHelper interface method
    ///////////////////////////////////////////////////////////////////////////

    public android.view.View getLoadingLogo() {
        return loadingLogo;
    }


    ///////////////////////////////////////////////////////////////////////////
    // AuthorizationFragment interface methods - see AuthorizationFragment
    // interface javadoc
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public android.view.View getSharedLoginEditText() {
        return mLoginEditText;
    }

    @Override
    public android.view.View getSharedPasswordEditText() {
        return mPasswordEditText;
    }


    ///////////////////////////////////////////////////////////////////////////
    // Mosby Lce Fragment methods
    ///////////////////////////////////////////////////////////////////////////

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return e.getLocalizedMessage();
    }

    @Override
    public void setData(Object data) {
        // no-op, we have no exact data here
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        // no-op, we have no exact data here
    }
}
