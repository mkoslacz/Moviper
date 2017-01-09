package com.mateuszkoslacz.moviper.ipcsample.viper.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.mateuszkoslacz.moviper.base.view.fragment.autoinject.butterknife.ViperButterKnifeFragment;
import com.mateuszkoslacz.moviper.ipcsample.R;
import com.mateuszkoslacz.moviper.ipcsample.constants.Constants;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.ColorWidgetContract;
import com.mateuszkoslacz.moviper.ipcsample.viper.presenter.ColorWidgetPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class ColorWidgetFragment
        extends ViperButterKnifeFragment<ColorWidgetContract.View, ColorWidgetContract.Presenter>
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

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_viper;
    }
}
