package com.mateuszkoslacz.moviper.ipcsample.viper.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mateuszkoslacz.moviper.base.view.fragment.ViperFragment;
import com.mateuszkoslacz.moviper.ipcsample.R;
import com.mateuszkoslacz.moviper.ipcsample.constants.Constants;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.ColorWidgetContract;
import com.mateuszkoslacz.moviper.ipcsample.viper.presenter.ColorWidgetPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ColorWidgetFragment
        extends ViperFragment<ColorWidgetContract.View, ColorWidgetContract.Presenter>
        implements ColorWidgetContract.View {

    @BindView(R.id.color_name)
    TextView textViewColorName;

    public static ColorWidgetFragment create(String name, int color) {
        ColorWidgetFragment colorWidgetFragment = new ColorWidgetFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ColorWidgetPresenter.FRAGMENT_COLOR_NAME, name);
        bundle.putInt(ColorWidgetPresenter.FRAGMENT_BACKGROUND_COLOR, color);
        colorWidgetFragment.setArguments(bundle);
        return colorWidgetFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_viper, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        getPresenter().onViewCreated();
    }

    @OnClick(R.id.button_first)
    void onFirstButtonClick() {
        getPresenter().synchronizeColorOfWidgetNamed(Constants.NAME_BLUE);
    }

    @OnClick(R.id.button_second)
    void onSecondButtonClick() {
        getPresenter().synchronizeColorOfWidgetNamed(Constants.NAME_GREEN);
    }

    @OnClick(R.id.button_third)
    void onThirdButtonClick() {
        getPresenter().synchronizeColorOfWidgetNamed(Constants.NAME_RED);
    }

    @OnClick(R.id.button_all)
    void onAllButtonClick() {
        getPresenter().synchronizeWidgetsColor();
    }

    @Override
    public void setName(String name) {
        textViewColorName.setText(name);
    }

    @Override
    public void setBackgroundColor(int color) {
        getView().setBackgroundColor(color);
    }

    @NonNull
    @Override
    public ColorWidgetContract.Presenter createPresenter() {
        return new ColorWidgetPresenter(getArguments());
    }
}
