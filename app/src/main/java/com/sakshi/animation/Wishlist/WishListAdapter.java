package com.sakshi.animation.Wishlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sakshi.animation.R;

import java.util.List;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.viewHolder> {
    private List<WishListModel> wishListModelList;

    public WishListAdapter(List<WishListModel> wishListModelList) {
        this.wishListModelList = wishListModelList;
    }

    @NonNull
    @Override
    public WishListAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wishlist_latout,viewGroup,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WishListAdapter.viewHolder viewHolder, int position) {
        int resource=wishListModelList.get(position).getProduct_image();
        String title=wishListModelList.get(position).getProductTitle();
        int freeCoupon=wishListModelList.get(position).getFree_coupon();
        String rating=wishListModelList.get(position).getRating();
        int totalRating=wishListModelList.get(position).getTotal_rating();
        String productPrice=wishListModelList.get(position).getProductPrice();
        String cuttedPrice=wishListModelList.get(position).getCuttedPrice();
        String paymentMethod=wishListModelList.get(position).getPaymentMethod();
        viewHolder.setData(resource,title,freeCoupon,rating,totalRating,productPrice,cuttedPrice,paymentMethod);

    }

    @Override
    public int getItemCount() {
        return wishListModelList.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage,couponIcon,deleteBtn;
        private TextView productTitle,productPice,cuttedPrice,paymentMethod,freeCoupon,rating,totalRating;
        private View priceCut;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.product_image);
            productTitle=itemView.findViewById(R.id.product_title);
            freeCoupon=itemView.findViewById(R.id.tv_free_coupon);
            couponIcon=itemView.findViewById(R.id.coupon_validity);
            rating=itemView.findViewById(R.id.tv_product_rating);
            totalRating=itemView.findViewById(R.id.total_ratings);
            priceCut=itemView.findViewById(R.id.price_cut);
            productPice=itemView.findViewById(R.id.product_price);
            cuttedPrice=itemView.findViewById(R.id.cutted_price);
            paymentMethod=itemView.findViewById(R.id.payment_method);
            deleteBtn=itemView.findViewById(R.id.delete_btn);

        }
        public  void  setData(int resource, String title, int freeCouponNo, String avg_rate, int total_rating_no, String price, String cuttedpricevalue, String payMethod){
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if (freeCouponNo > 0) {
                freeCoupon.setVisibility(View.VISIBLE);
                couponIcon.setVisibility(View.VISIBLE);
                if (freeCouponNo == 1) {
                    freeCoupon.setText("free " +  freeCouponNo  + " coupon");
                } else {
                    freeCoupon.setText("free " + freeCouponNo + " coupons");
                }
            } else {
                freeCoupon.setVisibility(View.INVISIBLE);
                couponIcon.setVisibility(View.INVISIBLE);
            }
            rating.setText(avg_rate);
            totalRating.setText(total_rating_no + " (rating)");
            productPice.setText(price);
            cuttedPrice.setText(cuttedpricevalue);
            paymentMethod.setText(payMethod);
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "delete", Toast.LENGTH_SHORT).show();
                }
            });

            }




        }
    }

