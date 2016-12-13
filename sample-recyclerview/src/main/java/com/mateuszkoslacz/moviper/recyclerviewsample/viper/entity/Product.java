package com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class Product {

    private String title;
    private String description;
    private String price;
    private String photoUrl;

    private Product(Builder builder) {
        title = builder.title;
        description = builder.description;
        price = builder.price;
        photoUrl = builder.photoUrl;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public static final class Builder {
        private String title;
        private String description;
        private String price;
        private String photoUrl;

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

        public Product build() {
            return new Product(this);
        }
    }
}
