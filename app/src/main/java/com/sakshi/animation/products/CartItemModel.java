package com.sakshi.animation.products;

public class CartItemModel {
    public static final int CART_ITEM =0;
    public static final int TOTAL_AMOUNT = 1;

    public CartItemModel(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    private  int type;
    ///////// cart item //////////
    private  int product_image;
    private  String product_title;
    private int free_coupuns;
    private  String product_price;
    private String product_cutted_price;

    private  int productQuantity;
    private int offerApplied;
    private int couponAppiled;

    public CartItemModel(int type, int product_image, String product_title, int free_coupuns, String product_price, String product_cutted_price, int productQuantity, int offerApplied, int couponAppiled) {
        this.type = type;
        this.product_image = product_image;
        this.product_title = product_title;
        this.free_coupuns = free_coupuns;
        this.product_price = product_price;
        this.product_cutted_price = product_cutted_price;
        this.productQuantity = productQuantity;
        this.offerApplied = offerApplied;
        this.couponAppiled = couponAppiled;
    }

    public static int getCartItem() {
        return CART_ITEM;
    }

    public static int getTotalAmount() {
        return TOTAL_AMOUNT;
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

    public int getFree_coupuns() {
        return free_coupuns;
    }

    public void setFree_coupuns(int free_coupuns) {
        this.free_coupuns = free_coupuns;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_cutted_price() {
        return product_cutted_price;
    }

    public void setProduct_cutted_price(String product_cutted_price) {
        this.product_cutted_price = product_cutted_price;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getOfferApplied() {
        return offerApplied;
    }

    public void setOfferApplied(int offerApplied) {
        this.offerApplied = offerApplied;
    }

    public int getCouponAppiled() {
        return couponAppiled;
    }

    public void setCouponAppiled(int couponAppiled) {
        this.couponAppiled = couponAppiled;
    }
    ///////// cart item //////////

    //////cart total amount//////
    private  String total_item;
    private String total_itemPrice;
    private String Delivery_price;
    private String saved_amount;
    private  String total_amount;

    public CartItemModel(int type, String total_item, String total_itemPrice, String delivery_price, String saved_amount, String total_amount) {
        this.type = type;
        this.total_item = total_item;
        this.total_itemPrice = total_itemPrice;
        Delivery_price = delivery_price;
        this.saved_amount = saved_amount;
        this.total_amount = total_amount;
    }

    public String getTotal_item() {
        return total_item;
    }

    public void setTotal_item(String total_item) {
        this.total_item = total_item;
    }

    public String getTotal_itemPrice() {
        return total_itemPrice;
    }

    public void setTotal_itemPrice(String total_itemPrice) {
        this.total_itemPrice = total_itemPrice;
    }

    public String getDelivery_price() {
        return Delivery_price;
    }

    public void setDelivery_price(String delivery_price) {
        Delivery_price = delivery_price;
    }

    public String getSaved_amount() {
        return saved_amount;
    }

    public void setSaved_amount(String saved_amount) {
        this.saved_amount = saved_amount;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }
//////cart total amount//////

}
