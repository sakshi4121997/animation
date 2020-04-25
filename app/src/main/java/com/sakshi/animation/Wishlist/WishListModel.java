package com.sakshi.animation.Wishlist;

public class WishListModel {
    private int product_image;
    private String productTitle;
    private int free_coupon;
    private String rating;
    private int total_rating;
    private String productPrice;
    private String cuttedPrice;
    private String paymentMethod;

    public WishListModel(int product_image, String productTitle, int free_coupon, String rating, int total_rating, String productPrice, String cuttedPrice, String paymentMethod) {
        this.product_image = product_image;
        this.productTitle = productTitle;
        this.free_coupon = free_coupon;
        this.rating = rating;
        this.total_rating = total_rating;
        this.productPrice = productPrice;
        this.cuttedPrice = cuttedPrice;
        this.paymentMethod = paymentMethod;
    }

    public int getProduct_image() {
        return product_image;
    }

    public void setProduct_image(int product_image) {
        this.product_image = product_image;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getFree_coupon() {
        return free_coupon;
    }

    public void setFree_coupon(int free_coupon) {
        this.free_coupon = free_coupon;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getTotal_rating() {
        return total_rating;
    }

    public void setTotal_rating(int total_rating) {
        this.total_rating = total_rating;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getCuttedPrice() {
        return cuttedPrice;
    }

    public void setCuttedPrice(String cuttedPrice) {
        this.cuttedPrice = cuttedPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
