package com.mateuszkoslacz.moviper.recyclerviewsample;

import android.support.test.espresso.Espresso;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.mateuszkoslacz.moviper.recyclerviewsample.rules.ViewHolderInstrumentedTestRule;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.viewholder.ProductViewHolder;

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
    public ViewHolderInstrumentedTestRule<Product> mTestRule = new ViewHolderInstrumentedTestRule<>(
            () -> getViewId(),
            view -> getViewHolder(view),
            () -> getModel()
    );

    @Test
    public void setTitle() throws Exception {
        mTestRule.launchActivity(null);

        String titleToBeDisplayed = "Title";
        Espresso.onView(withId(R.id.product_title)).check(matches(withText(titleToBeDisplayed)));
    }

    @Test
    public void setDescription() throws Exception {
        mTestRule.launchActivity(null);

        String descToBeDisplayed = "Desc";
        Espresso.onView(withId(R.id.product_description)).check(matches(withText(descToBeDisplayed)));
    }

    private int getViewId() {
        return R.layout.vh_product;
    }

    private Product getModel() {
        Product product = new Product.Builder()
                .title("Title")
                .price("Price")
                .description("Desc")
                .build();

        return product;
    }

    private ProductViewHolder getViewHolder(View view) {
        return new ProductViewHolder(view);
    }
}