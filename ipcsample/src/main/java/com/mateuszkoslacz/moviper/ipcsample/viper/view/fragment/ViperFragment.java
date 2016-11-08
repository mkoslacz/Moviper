package com.mateuszkoslacz.moviper.ipcsample.viper.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.mateuszkoslacz.moviper.ipcsample.R;
import com.mateuszkoslacz.moviper.ipcsample.util.Constants;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.ViperContract;
import com.mateuszkoslacz.moviper.ipcsample.viper.presenter.ViperPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViperFragment
        extends MvpFragment<ViperContract.View, ViperContract.Presenter>
        implements ViperContract.View, ViperContract.ViewHelper {

    @BindView(R.id.color_name)
    TextView textViewColorName;
    @BindView(R.id.button_first)
    Button buttonFirst;
    @BindView(R.id.button_second)
    Button buttonSecond;
    @BindView(R.id.button_third)
    Button buttonThird;
    @BindView(R.id.button_all)
    Button buttonAll;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_viper, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        getPresenter().onViewCreated();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        buttonFirst.setOnClickListener(view -> getPresenter().onButtonClick(Constants.FRAGMENT_NAME_FIRST));
        buttonSecond.setOnClickListener(view -> getPresenter().onButtonClick(Constants.FRAGMENT_NAME_SECOND));
        buttonThird.setOnClickListener(view -> getPresenter().onButtonClick(Constants.FRAGMENT_NAME_THIRD));
        buttonAll.setOnClickListener(view -> getPresenter().onButtonClick());
    }

    @Override
    public void setColorName(String colorName) {
        textViewColorName.setText(colorName);
    }

    @Override
    public void setBackgroundColor(int color) {
        getActivity().runOnUiThread(() -> getView().setBackgroundColor(color));
    }

    @NonNull
    @Override
    public ViperContract.Presenter createPresenter() {
        return new ViperPresenter(this, getArguments());
    }
}
