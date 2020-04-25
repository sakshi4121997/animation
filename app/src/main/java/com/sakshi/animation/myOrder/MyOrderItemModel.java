package com.sakshi.animation.myOrder;

public class MyOrderItemModel {
    private int product_image;
    private int saving_rating;
    private String productTitle;
    private String deliveryStatus;

    public MyOrderItemModel(int product_image, int saving_rating, String productTitle, String deliveryStatus) {
        this.product_image = product_image;
        this.saving_rating = saving_rating;
        this.productTitle = productTitle;
        this.deliveryStatus = deliveryStatus;
    }

    public int getProduct_image() {
        return product_image;
    }

    public void setProduct_image(int product_image) {
        this.product_image = product_image;
    }

    public int getSaving_rating() {
        return saving_rating;
    }

    public void setSaving_rating(int saving_rating) {
        this.saving_rating = saving_rating;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}