package com.mateuszkoslacz.moviper.recyclerviewsample;

import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter.ProductPresenter;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.viewholder.ProductViewHolder;
import com.mateuszkoslacz.moviper.tests.views.ViewHolderUnitTestActivity;

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

    //TODO: reconsider if we should pull up setup to an abstract class
    @Before
    public void setUp() throws Exception {
        mActivity = Robolectric.setupActivity(ViewHolderUnitTestActivity.class);
        mActivity.createViewHolderLayout(R.layout.vh_product);
        mViewHolder = new ProductViewHolder(mActivity.getViewHolderLayout());
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void isPresenterAttached() {
        mViewHolder.setDataObject(createTestProduct());
        mViewHolder.bindPresenter();

        Mockito.verify(mPresenter).attachView(Mockito.any());
    }

    private Product createTestProduct() {
        return new Product.Builder()
                .title("Title")
                .price("Price")
                .description("Desc")
                .build();
    }
}