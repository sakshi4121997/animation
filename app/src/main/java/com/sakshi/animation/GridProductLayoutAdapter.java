package com.sakshi.animation;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sakshi.animation.products.ProductDetailsActivity;

import java.util.List;

public class GridProductLayoutAdapter extends BaseAdapter {
    public GridProductLayoutAdapter(List<HorizontalProductScrollModelClass> horizontalProductScrollModelClassList) {
        this.horizontalProductScrollModelClassList = horizontalProductScrollModelClassList;
    }

    List<HorizontalProductScrollModelClass> horizontalProductScrollModelClassList;
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View view;
        if(convertView==null){
            view= (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scroll_layout_item,null);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#ffffff"));

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetailIntent=new Intent(parent.getContext(), ProductDetailsActivity.class);
                    parent.getContext().startActivity(productDetailIntent);
                }
            });

            ImageView product_image=view.findViewById(R.id.h_s_product_image);
            TextView product_title=view.findViewById(R.id.h_s_product_title);
            TextView product_discription=view.findViewById(R.id.h_s_product_discription);
            TextView product_price=view.findViewById(R.id.h_s_product_price);

            product_image.setImageResource(horizontalProductScrollModelClassList.get(position).getProduct_image());
            product_title.setText(horizontalProductScrollModelClassList.get(position).getProduct_title());
            product_discription.setText(horizontalProductScrollModelClassList.get(position).getProduct_discription());
            product_price.setText(horizontalProductScrollModelClassList.get(position).getProduct_price());

        }else {
            view=convertView;

        }
        return view;
    }
}
