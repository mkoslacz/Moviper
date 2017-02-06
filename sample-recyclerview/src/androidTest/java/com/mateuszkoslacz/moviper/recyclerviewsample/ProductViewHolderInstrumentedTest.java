package com.mateuszkoslacz.moviper.recyclerviewsample;

import android.support.test.espresso.Espresso;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.viewholder.ProductViewHolder;
import com.mateuszkoslacz.moviper.tests.rules.ViewHolderTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

/**
 * Created by tomasznajda on 05.12.2016.
 */
@RunWith(AndroidJUnit4.class)
public class ProductViewHolderInstrumentedTest {

    @Rule
    public ViewHolderTestRule<Product> mTestRule =
            ViewHolderTestRule.builder()
                    .withViewId(R.layout.vh_product)
                    .withModelObject(createTestProduct())
                    .withViewHolderDelegate(this::getViewHolder)
                    .build();

    @Test
    public void setTitle() throws Exception {
        mTestRule.launchActivity(null);
        Espresso.onView(withId(R.id.product_title)).check(matches(withText("Title")));
    }

    @Test
    public void setDescription() throws Exception {
        mTestRule.launchActivity(null);
        Espresso.onView(withId(R.id.product_description)).check(matches(withText("Desc")));
    }

    private Product createTestProduct() {
        return new Product.Builder()
                .title("Title")
                .price("Price")
                .description("Desc")
                .build();
    }

    private ProductViewHolder getViewHolder(View view) {
        return new ProductViewHolder(view);
    }
}