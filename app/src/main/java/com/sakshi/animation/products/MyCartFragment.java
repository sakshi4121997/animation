package com.sakshi.animation.products;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.sakshi.animation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyCartFragment extends Fragment {


    public MyCartFragment() {
        // Required empty public constructor
    }
 private RecyclerView cartItemRecyclerView;
    private Button continue_btn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_my_cart, container, false);
        continue_btn=view.findViewById(R.id.cart_continue_btn);
        cartItemRecyclerView=view.findViewById(R.id.cart_items_recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemRecyclerView.setLayoutManager(linearLayoutManager);

        List<CartItemModel> cartItemModelList=new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.lady,"pixel 24",5,"Rs676676/-","Rs.44566/-",1,0,5));
        cartItemModelList.add(new CartItemModel(0,R.drawable.phone1,"pixel 44",5,"Rs76676/-","Rs.44566/-",3,2,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.lady,"pixel 24",8,"Rs6676/-","Rs.44566/-",1,3,4));
        cartItemModelList.add(new CartItemModel(0,R.drawable.phone1,"pixel 84",5,"Rs66776/-","Rs.44566/-",8,0,6));
        cartItemModelList.add(new CartItemModel(1,"price(5 items)","RS.677/-","Free"," You saved Rs100/- on your shopping ","Rs.1667/-"));
        CartAdapter cartAdapter=new CartAdapter(cartItemModelList);
        cartItemRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        continue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliverIntent=new Intent(getContext(),AddressActivity.class);
                getContext().startActivity(deliverIntent);
            }
        });


        return view;
    }

}
