package com.sakshi.animation;

public class HorizontalProductScrollModelClass {
    private int product_image;
    private String product_title;
    private String product_discription;
    private String product_price;

    public HorizontalProductScrollModelClass(int product_image, String product_title, String product_discription, String product_price) {
        this.product_image = product_image;
        this.product_title = product_title;
        this.product_discription = product_discription;
        this.product_price = product_price;
    }

    public int getProduct_image() {
        return product_image;
    }

    public void setProduct_image(int product_image) {
        this.product_image = product_image;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getProduct_discription() {
        return product_discription;
    }

    public void setProduct_discription(String product_discription) {
        this.product_discription = product_discription;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }
}

