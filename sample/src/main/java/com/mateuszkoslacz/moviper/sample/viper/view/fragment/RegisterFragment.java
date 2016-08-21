package com.mateuszkoslacz.moviper.sample.viper.view.fragment;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.mateuszkoslacz.moviper.sample.R;
import com.mateuszkoslacz.moviper.sample.data.bundle.RegisterBundle;
import com.mateuszkoslacz.moviper.sample.util.LocationUtils;
import com.mateuszkoslacz.moviper.sample.viper.contract.RegisterContract;
import com.mateuszkoslacz.moviper.sample.viper.presenter.RegisterPresenter;
import com.mateuszkoslacz.moviper.sample.viper.view.fragment.iface.AuthorizationFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mateuszkoslacz on 25.07.2016.
 * <p>
 * Sample of custom LCE management. See {@link LoginFragment} to check out Mosby LCE management.
 */
// TODO blocking touch ui on loading
public class RegisterFragment extends MvpFragment<RegisterContract.View, RegisterContract.Presenter>
        implements AuthorizationFragment, RegisterContract.View, RegisterContract.ViewHelper {

    @BindView(R.id.fragment_authorization_register_edittext_login)
    EditText mLoginEditText;
    @BindView(R.id.fragment_authorization_register_edittext_email)
    EditText mEmailEditText;
    @BindView(R.id.fragment_authorization_register_edittext_password)
    EditText mPasswordEditText;
    @BindView(R.id.loadingView)
    LinearLayout loadingView;


    // I DO NOT encourage block comments in non-sample code! Organize your code
    // in the self-explaining way and block comments will become redundant.
    ///////////////////////////////////////////////////////////////////////////
    // initializer
    ///////////////////////////////////////////////////////////////////////////

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(
                R.layout.fragment_authorization_register,
                container,
                false);
        ButterKnife.bind(this, view);
        return view;
    }


    ///////////////////////////////////////////////////////////////////////////
    // events handling - propagating UI events to the Presenter
    ///////////////////////////////////////////////////////////////////////////

    @OnClick(R.id.fragment_authorization_register_btn_show_login)
    void onGotoLoginBtnClick() {
        presenter.onShowLoginFragmentClicked();
    }

    @OnClick(R.id.fragment_authorization_register_btn_register)
    void onRegisterButtonClick() {
        getPresenter().onRegisterClicked(
                new RegisterBundle.Builder()
                        .withLogin(mLoginEditText.getText().toString())
                        .withEmail(mEmailEditText.getText().toString())
                        .withPassword(mPasswordEditText.getText().toString())
                        .build());
    }

    /**
     * Example of propagating an Activity/Fragment specific Android behaviour to the Routing.
     * In this case it's handling of a permissions request result.
     * <p>
     * Well, this isn't the best thing we have here and at the moment it cannot be detached from
     * Android components. Actually, this is a logic of the Routing in the View.
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LocationUtils.PERMISSION_REQUEST_ACCES_FINE_LOCATION &&
                permissions.length != 0 &&
                grantResults.length != 0) {
            ((RegisterContract.PresenterForRouting) getPresenter())
                    .onRequestLocalizationPermissionsResult(
                            grantResults[0] == PackageManager.PERMISSION_GRANTED);
        }
    }


    ///////////////////////////////////////////////////////////////////////////
    // creating the Presenter
    ///////////////////////////////////////////////////////////////////////////

    @NonNull
    @Override
    public RegisterContract.Presenter createPresenter() {
        return new RegisterPresenter(this);
    }


    ///////////////////////////////////////////////////////////////////////////
    // View interface methods
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void showLoadingView() {
        TransitionManager.beginDelayedTransition(((ViewGroup) getView()));
        loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayError(String msg) {
        //TODO do it better (faster, stronger)
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
        TransitionManager.beginDelayedTransition(((ViewGroup) getView()));
        loadingView.setVisibility(View.GONE);
    }


    ///////////////////////////////////////////////////////////////////////////
    // AuthorizationFragment interface methods - see AuthorizationFragment
    // interface javadoc
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public View getSharedLoginEditText() {
        return mLoginEditText;
    }

    @Override
    public View getSharedPasswordEditText() {
        return mPasswordEditText;
    }

}
