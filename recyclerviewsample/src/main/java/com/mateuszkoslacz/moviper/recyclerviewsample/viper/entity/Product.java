package com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity;

import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.category.ICategory;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class Product {

    private String title;
    private String description;
    private String price;
    private String photoUrl;
    private ICategory category;

    private Product(Builder builder) {
        title = builder.title;
        description = builder.description;
        price = builder.price;
        photoUrl = builder.photoUrl;
        category = builder.category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public ICategory getCategory() {
        return category;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public static final class Builder {
        private String title;
        private String description;
        private String price;
        private String photoUrl;
        private ICategory category;

        public Builder() {
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder photoUrl(String val) {
            photoUrl = val;
            return this;
        }

        public Builder price(String val) {
            price = val;
            return this;
        }

        public Builder category(ICategory val) {
            category = val;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
