package com.sakshi.animation.myOrder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.sakshi.animation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyOrderFragment extends Fragment {


    public MyOrderFragment() {
        // Required empty public constructor
    }

    private RecyclerView myOrderRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_order, container, false);
        myOrderRecyclerView=view.findViewById(R.id.my_order_recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myOrderRecyclerView.setLayoutManager(linearLayoutManager);

        List<MyOrderItemModel> myOrderItemModelList=new ArrayList<>();
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.lady,3,"pixcel 2XL(BLACK)","deliver on tue 15 april 2020"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.phone1,1,"pixcel 2XL(BLACK)","deliver on tue 15 april 2020"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.lady,2,"pixcel 2XL(BLACK)","canceled"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.ic_email_blue,4,"pixcel 2XL(BLACK)","deliver on tue 15 april 2020"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.ic_email_green,3,"pixcel 2XL(BLACK)","deliver on tue 15 april 2020"));
       MyOrderAdapter myOrderAdapter=new MyOrderAdapter(myOrderItemModelList);
       myOrderRecyclerView.setAdapter(myOrderAdapter);
       myOrderAdapter.notifyDataSetChanged();
        return view;
    }

}
