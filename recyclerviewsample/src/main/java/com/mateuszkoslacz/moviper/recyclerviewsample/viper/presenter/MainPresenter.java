package com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBaseRxPresenter;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.category.Laptop;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.category.Smartphone;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.category.Tablet;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.interactor.MainInteractor;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.routing.MainRouting;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.IListingItem;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.HeaderItem;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.ProductItem;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter
        extends ViperActivityBaseRxPresenter
        <MainContract.View,
                MainContract.Interactor,
                MainContract.Routing>
        implements
        MainContract.Presenter {

    public MainPresenter(Activity activity) {
        super(activity);
    }

    @Override
    public void onViewCreated() {
        List<IListingItem> listingItems = new ArrayList<>();
        for (Product product : getFakeProductList()) {
            listingItems.add(new ProductItem(product));
        }
        listingItems.add(5, new HeaderItem("Laptops"));
        listingItems.add(3, new HeaderItem("Tablets"));
        listingItems.add(0, new HeaderItem("Smartphones"));

        if (isViewAttached()) {
            getView().setListingItems(listingItems);
        }
    }

    @NonNull
    @Override
    public MainContract.Routing createRouting(@NonNull Activity activity) {
        return new MainRouting(activity);
    }

    @NonNull
    @Override
    public MainContract.Interactor createInteractor() {
        return new MainInteractor();
    }

    private List<Product> getFakeProductList() {
        // Smartphones
        Product smartphone1 = new Product.Builder()
                .title("OnePlus 3")
                .description("A truly affordable flagship killer. If you're short on cash, this is the smartphone to get")
                .price("309")
                .category(new Smartphone())
                .photoUrl("http://images.cdn.stuff.tv/sites/stuff.tv/files/styles/teaser-products-top10-retina/public/brands/OnePus/OnePlus_3/Review/oneplus-3-10.jpg?itok=v5X1tbjL&timestamp=1466166365")
                .build();
        Product smartphone2 = new Product.Builder()
                .title("Samsung Galaxy S7")
                .description("How do you trump the best phone of 2015? You make it again, but better. A near £300 price gap means the OnePlus 3 is a better buy though")
                .price("570")
                .category(new Smartphone())
                .photoUrl("http://images.cdn.stuff.tv/sites/stuff.tv/files/styles/teaser-products-top10-retina/public/brands/Samsung/Galaxy-s7/Review/samsung_s7_web10.jpg?itok=1Cm6SNuO&timestamp=1457384319")
                .build();
        Product smartphone3 = new Product.Builder()
                .title("Apple iPhone 7 Plus")
                .description("The best iPhone camera ever, best iPhone screen ever and excellent battery life - there's no better iOS choice")
                .price("719")
                .category(new Smartphone())
                .photoUrl("http://images.cdn.stuff.tv/sites/stuff.tv/files/styles/teaser-products-top10-retina/public/brands/Apple/iPhone_7/iPhone_7_Plus_review/apple_iphone_7_plus_intro.jpg?itok=hLF8vKup&timestamp=1473746588")
                .build();
        // Tablets
        Product tablet1 = new Product.Builder()
                .title("Apple iPad Pro 9.7")
                .description("Is this the ultimate iPad? Spoiler: yes")
                .price("500")
                .category(new Tablet())
                .photoUrl("http://images.cdn.stuff.tv/sites/stuff.tv/files/styles/teaser-products-top10-retina/public/brands/Apple/iPad_Pro_small/ipad_pro_9.jpg?itok=xZ_ArsUx&timestamp=1459596732")
                .build();
        Product tablet2 = new Product.Builder()
                .title("Samsung Galaxy Tab S2 8.0")
                .description("Small but mighty, Samsung's mini Android tablet is seriously good")
                .price("319")
                .category(new Tablet())
                .photoUrl("http://images.cdn.stuff.tv/sites/stuff.tv/files/styles/teaser-products-top10-retina/public/brands/Apple/iPad_Pro_small/ipad_pro_9.jpg?itok=xZ_ArsUx&timestamp=1459596732")
                .build();
        // Laptops
        Product laptop1 = new Product.Builder()
                .title("MacBook Pro 13in (2015)")
                .description("Apple's latest annual update to the already brilliant Pro keeps it at top of the laptop pops")
                .price("1000")
                .category(new Laptop())
                .photoUrl("http://images.cdn.stuff.tv/sites/stuff.tv/files/styles/teaser-products-top10-retina/public/brands/Apple/Macbook_Pro_13in_2015/mbp13-1.jpg?itok=VGXbh-hQ&timestamp=1427888359")
                .build();
        Product laptop2 = new Product.Builder()
                .title("Dell XPS 13 (2015)")
                .description("An excellent Windows 10 ultrabook that's small in size and great in stature")
                .price("1149")
                .category(new Laptop())
                .photoUrl("http://images.cdn.stuff.tv/sites/stuff.tv/files/styles/teaser-products-top10-retina/public/brands/Dell/XPS-13-2015/xs13.png?itok=8qqJuLCS&timestamp=1449763792")
                .build();

        List<Product> fakeProductList = new ArrayList();
        fakeProductList.add(smartphone1);
        fakeProductList.add(smartphone2);
        fakeProductList.add(smartphone3);
        fakeProductList.add(tablet1);
        fakeProductList.add(tablet2);
        fakeProductList.add(laptop1);
        fakeProductList.add(laptop2);

        return fakeProductList;
    }
}
