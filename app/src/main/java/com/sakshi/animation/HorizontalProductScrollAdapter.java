package com.sakshi.animation;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sakshi.animation.products.ProductDetailsActivity;

import java.util.List;

public class HorizontalProductScrollAdapter extends RecyclerView.Adapter<HorizontalProductScrollAdapter.viewHolder> {
    private List<HorizontalProductScrollModelClass> horizontalProductScrollModelClassList;

    public HorizontalProductScrollAdapter(List<HorizontalProductScrollModelClass> horizontalProductScrollModelClassList) {
        this.horizontalProductScrollModelClassList = horizontalProductScrollModelClassList;
    }

    @NonNull
    @Override
    public HorizontalProductScrollAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_scroll_layout_item,viewGroup,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalProductScrollAdapter.viewHolder viewHolder, int position) {
       int resource=horizontalProductScrollModelClassList.get(position).getProduct_image();
       String title=horizontalProductScrollModelClassList.get(position).getProduct_title();
       String discription=horizontalProductScrollModelClassList.get(position).getProduct_discription();
       String price=horizontalProductScrollModelClassList.get(position).getProduct_price();
       viewHolder.setProctImage(resource);
       viewHolder.setProductTitle(title);
       viewHolder.setProductDiscription(discription);
       viewHolder.setProductPrice(price);

    }

    @Override
    public int getItemCount() {
        if(horizontalProductScrollModelClassList.size()>8){
            return 8;
        }else {
            return horizontalProductScrollModelClassList.size();
        }

    }
    public class viewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage;
        private TextView productTitle,productDiscription,productPrice;

        public viewHolder(@NonNull final View itemView) {
            super(itemView);
            productImage=itemView.findViewById(R.id.h_s_product_image);
            productTitle=itemView.findViewById(R.id.h_s_product_title);
            productDiscription=itemView.findViewById(R.id.h_s_product_discription);
            productPrice=itemView.findViewById(R.id.h_s_product_price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productdetailIntent=new Intent(itemView.getContext(), ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productdetailIntent);
                }
            });
        }
        private void setProctImage(int resource){
            productImage.setImageResource(resource);
        }
        private void setProductTitle(String title)
        {
            productTitle.setText(title);
        }
        private void setProductDiscription(String discription){
            productDiscription.setText(discription);
        }
        private void setProductPrice(String prize)
        {
            productPrice.setText(prize);
        }
    }

}
