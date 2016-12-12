package com.mateuszkoslacz.moviper.recyclerviewsample;

import com.mateuszkoslacz.moviper.recyclerviewsample.utils.ViewHolderUnitTestActivity;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter.ProductPresenter;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.viewholder.ProductViewHolder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by tomasznajda on 05.12.2016.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ProductViewHolderUnitTest {

    @Mock
    public ProductPresenter mPresenter;

    @InjectMocks
    public ProductViewHolder mViewHolder;

    private ViewHolderUnitTestActivity mActivity;
    private int mViewHolderViewId = R.layout.vh_product;

    @Before
    public void setUp() throws Exception {
        startActivity();
        initViewHolder(mActivity);
    }

    @Test
    public void isPresenterAttached() {
        mViewHolder.setDataObject(getModel());
        mViewHolder.bindPresenter();

        Mockito.verify(mPresenter).attachView(Mockito.any());
    }

    private void startActivity() {
        mActivity = Robolectric.setupActivity(ViewHolderUnitTestActivity.class);
        mActivity.addViewHolderView(mViewHolderViewId);
    }

    private void initViewHolder(ViewHolderUnitTestActivity activity) {
        mViewHolder = new ProductViewHolder(activity.getViewHolderView());
        MockitoAnnotations.initMocks(this);
    }

    private Product getModel() {
        Product product = new Product.Builder()
                .title("Title")
                .price("Price")
                .description("Desc")
                .build();

        return product;
    }
}