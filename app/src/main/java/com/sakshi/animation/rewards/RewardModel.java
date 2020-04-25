package com.sakshi.animation.rewards;

public class RewardModel {
    private String reward_title;
    private String expary_date;
    private String coupon_body;

    public RewardModel(String reward_title, String expary_date, String coupon_body) {
        this.reward_title = reward_title;
        this.expary_date = expary_date;
        this.coupon_body = coupon_body;
    }

    public String getReward_title() {
        return reward_title;
    }

    public void setReward_title(String reward_title) {
        this.reward_title = reward_title;
    }

    public String getExpary_date() {
        return expary_date;
    }

    public void setExpary_date(String expary_date) {
        this.expary_date = expary_date;
    }

    public String getCoupon_body() {
        return coupon_body;
    }

    public void setCoupon_body(String coupon_body) {
        this.coupon_body = coupon_body;
    }
}
