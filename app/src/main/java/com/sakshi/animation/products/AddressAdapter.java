package com.sakshi.animation.products;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sakshi.animation.R;

import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.viewHolder> {
    private List<AddressModel> addressModelslist;

    public AddressAdapter(List<AddressModel> addressModelslist) {
        this.addressModelslist = addressModelslist;
    }

    @NonNull
    @Override
    public AddressAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.addresses_item_layout,viewGroup,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressAdapter.viewHolder viewHolder, int position) {
        String user_fullName=addressModelslist.get(position).getFullName();
        String user_addresses=addressModelslist.get(position).getAddress();
        String user_pincode=addressModelslist.get(position).getPincode();
        viewHolder.setData(user_fullName,user_addresses,user_pincode);

    }

    @Override
    public int getItemCount() {
        return addressModelslist.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder {
        TextView full_name,address,pinCode;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            full_name=itemView.findViewById(R.id.full_name);
            address=itemView.findViewById(R.id.address);
            pinCode=itemView.findViewById(R.id.pin_code);
        }

    void setData(String user_name,String user_address,String user_pincode){
        full_name.setText(user_name);
        address.setText(user_address);
        pinCode.setText(user_pincode);

    }
}}
