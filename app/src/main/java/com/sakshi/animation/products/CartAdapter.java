package com.sakshi.animation.products;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sakshi.animation.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter {
    private List<CartItemModel> cartItemModelList;

    public CartAdapter(List<CartItemModel> cartItemModelList) {
        this.cartItemModelList = cartItemModelList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case CartItemModel.CART_ITEM:
                View cartItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item_layout, viewGroup, false);
                return new CartItemViewHolder(cartItemView);
            case CartItemModel.TOTAL_AMOUNT:
                View cartTotalAmountView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_total_amount_layout, viewGroup, false);
                return new CartTotalAmountViewHolder(cartTotalAmountView);
            default:
                return null;
        }
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (cartItemModelList.get(position).getType()){
            case CartItemModel.CART_ITEM:
                int resource=cartItemModelList.get(position).getProduct_image();
                String title=cartItemModelList.get(position).getProduct_title();
                int freeCoupons=cartItemModelList.get(position).getFree_coupuns();

                String productPrice=cartItemModelList.get(position).getProduct_price();
                String cuttedPrice=cartItemModelList.get(position).getProduct_cutted_price();
                int offeredApplied=cartItemModelList.get(position).getOfferApplied();
                ((CartItemViewHolder)viewHolder).setItemDetail(resource,title,freeCoupons,productPrice,cuttedPrice,offeredApplied);
              break;
              case CartItemModel.TOTAL_AMOUNT:
                  String totalItem=cartItemModelList.get(position).getTotal_item();
                  String totalItemPrice=cartItemModelList.get(position).getTotal_itemPrice();
                  String deliveryPrice=cartItemModelList.get(position).getDelivery_price();
                  String totalAmount=cartItemModelList.get(position).getTotal_amount();
                  String savedAmount=cartItemModelList.get(position).getSaved_amount();
                  ((CartTotalAmountViewHolder)viewHolder).setTotalAmount(totalItem,totalItemPrice,deliveryPrice,totalAmount,savedAmount);
                  break;
                  default:
                      return;

        }

    }

    @Override
    public int getItemCount() {
        return cartItemModelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartItemModelList.get(position).getType()) {
            case 0:
                return CartItemModel.CART_ITEM;
            case 1:
                return CartItemModel.TOTAL_AMOUNT;
            default:
                return -1;
        }
    }

    public class CartItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage, free_coupon_icon;
        private TextView product_title, freeCoupon, product_price,
                offerApplied, couponApplied, productQuantity, cutted_price;


        public CartItemViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.delete_btn);
            product_title = itemView.findViewById(R.id.product_cart_title);
            freeCoupon = itemView.findViewById(R.id.tv_free_coupon);
            product_price = itemView.findViewById(R.id.cart_product_price);
            productQuantity = itemView.findViewById(R.id._product_quantity);
            offerApplied = itemView.findViewById(R.id.offers_applied);
            couponApplied = itemView.findViewById(R.id.coupon_appiled);
            cutted_price = itemView.findViewById(R.id.cart_cutted_price);
            free_coupon_icon = itemView.findViewById(R.id.free_coupon_icon);

        }

        private void setItemDetail(int resource, String title, int freeCouponNo,String productPriceText
                                    ,String cuttedPriceText,int offerAppliedNo) {
            productImage.setImageResource(resource);
            product_title.setText(title);
            if (freeCouponNo > 0) {
                freeCoupon.setVisibility(View.VISIBLE);
                free_coupon_icon.setVisibility(View.VISIBLE);
                if (freeCouponNo == 1) {
                    freeCoupon.setText("free " +  freeCouponNo  + " coupon");
                } else {
                    freeCoupon.setText("free " + freeCouponNo + " coupons");
                }
            } else {
                freeCoupon.setVisibility(View.INVISIBLE);
                free_coupon_icon.setVisibility(View.INVISIBLE);
            }


            product_price.setText(productPriceText);
            cutted_price.setText(cuttedPriceText);
            //for coupon
            if (offerAppliedNo > 0) {
                offerApplied.setVisibility(View.VISIBLE);
                offerApplied.setText(offerAppliedNo + " offer applied");
            } else {
                offerApplied.setVisibility(View.INVISIBLE);
            }


        }}

      public   class CartTotalAmountViewHolder extends RecyclerView.ViewHolder {
            private  TextView totalItems,totalItemsPrice,deliveryPrice,totalAmount,savedAmount;

            public CartTotalAmountViewHolder(@NonNull View itemView) {
                super(itemView);
                totalItems=itemView.findViewById(R.id.total_items);
                totalItemsPrice=itemView.findViewById(R.id.total_item_pricde);
                deliveryPrice=itemView.findViewById(R.id.derivery_charge_price);
                totalAmount=itemView.findViewById(R.id.total_price);
                savedAmount=itemView.findViewById(R.id.saveed_amount);

            }
            private void setTotalAmount(String totalItemText,String totalItemPricetext,String deliveryPriceText,String totalAmountText,String savedAmountText){
                totalItems.setText(totalItemText);
                totalItemsPrice.setText(totalItemPricetext);
                deliveryPrice.setText(deliveryPriceText);
                totalAmount.setText(totalAmountText);
                savedAmount.setText(savedAmountText);
            }
        }
    }


