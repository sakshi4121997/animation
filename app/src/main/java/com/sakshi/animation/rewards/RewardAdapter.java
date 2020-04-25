package com.sakshi.animation.rewards;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sakshi.animation.R;

import java.util.ArrayList;
import java.util.List;

public class RewardAdapter extends RecyclerView.Adapter<RewardAdapter.viewHolder> {
    List<RewardModel> rewardModelList;

    public RewardAdapter(List<RewardModel> rewardModelList) {
        this.rewardModelList = rewardModelList;
    }

    @NonNull
    @Override
    public RewardAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reward_item_layout,viewGroup,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RewardAdapter.viewHolder viewHolder, int position) {
  String coupon_title=rewardModelList.get(position).getReward_title();
  String coupon_validity=rewardModelList.get(position).getExpary_date();
  String coupon_body=rewardModelList.get(position).getCoupon_body();
    viewHolder.setData(coupon_title,coupon_validity,coupon_body);
    }

    @Override
    public int getItemCount() {
        return rewardModelList.size();
    }
     public class viewHolder extends RecyclerView.ViewHolder {
        TextView coupon_title,expiryDate,couponBody;
         public viewHolder(@NonNull View itemView) {
             super(itemView);
             coupon_title=itemView.findViewById(R.id.coupon_title);
             expiryDate=itemView.findViewById(R.id.coupon_validity);
             couponBody=itemView.findViewById(R.id.coupon_body);
         }

     private void setData(String title,String validity,String body) {
         coupon_title.setText(title);
         expiryDate.setText(validity);
         couponBody.setText(body);
     }
     }
}
