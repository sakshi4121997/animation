package com.sakshi.animation.myOrder;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sakshi.animation.R;

import java.util.List;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.viewHolder> {
    private List<MyOrderItemModel> myOrderItemModelList;
    private LinearLayout rateNowlayoutContainer;

    public MyOrderAdapter(List<MyOrderItemModel> myOrderItemModelList) {
        this.myOrderItemModelList = myOrderItemModelList;
    }

    @NonNull
    @Override
    public MyOrderAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_order_item_layout,viewGroup,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderAdapter.viewHolder viewHolder, int position) {
        int resource=myOrderItemModelList.get(position).getProduct_image();
        int saving_rating=myOrderItemModelList.get(position).getSaving_rating();
        String title=myOrderItemModelList.get(position).getProductTitle();
        String deliverDate=myOrderItemModelList.get(position).getDeliveryStatus();

        viewHolder.setData(resource,saving_rating,title,deliverDate);
    }

    @Override
    public int getItemCount() {
        return myOrderItemModelList.size();
    }


    class viewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage,orderdeliverIndicator;
        private TextView productTitle,deliverStatus;
        public viewHolder(@NonNull final View itemView) {
            super(itemView);
            rateNowlayoutContainer=itemView.findViewById(R.id.rate_now_container);
            productImage=itemView.findViewById(R.id.product_imager);
          orderdeliverIndicator=itemView.findViewById(R.id.deliver_indicator);
            productTitle=itemView.findViewById(R.id.product_title);
            rateNowlayoutContainer=itemView.findViewById(R.id.rate_now_container);
            deliverStatus=itemView.findViewById(R.id.order_delivered_date);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderDetailIntent=new Intent(itemView.getContext(),OrderDetailsActivity.class);
                itemView.getContext().startActivity(orderDetailIntent);
            }
        });}

        public void setData(int resource,int saving_rating,String title,String deliveryDate) {
            productImage.setImageResource(resource);
            productTitle.setText(title);
            if (deliveryDate.equals("canceled")) {
                orderdeliverIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.Red)));

            } else {
                orderdeliverIndicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.SucessGreen)));

            }
            deliverStatus.setText(deliveryDate);
            ///////rating layout////
setRating(saving_rating);
            //this will set the click listener in all star
            for(int x = 0;x < rateNowlayoutContainer.getChildCount();x++){
                //hr ek star ke liye position set ki h
                final int star_position= x;
                rateNowlayoutContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setRating(star_position);
                    }
                });

            }
            // /////rating layout////
        }


        private void setRating(int star_position) {
            //har ek star ka color chnge krega
            for(int x=0;x < rateNowlayoutContainer.getChildCount();x++){
                ImageView starbtn= (ImageView) rateNowlayoutContainer.getChildAt(x);
                starbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
                if(x <= star_position){
                    starbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#FFBB00")));
                }
            }
        }

            }
        }


