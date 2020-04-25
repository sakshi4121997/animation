package com.sakshi.animation.Wishlist;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sakshi.animation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyWishListFragment extends Fragment {
    private RecyclerView wishlistRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_wish_list, container, false);
        wishlistRecyclerView=view.findViewById(R.id.wishlist_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishlistRecyclerView.setLayoutManager(linearLayoutManager);

        List<WishListModel> wishListModelList=new ArrayList<>();
        wishListModelList.add(new WishListModel(R.drawable.phone1,"pixcel 2",1,"4",34,"Rs.46767/-","Rs.3679","cash on deliver"));
        wishListModelList.add(new WishListModel(R.drawable.phone1,"pixcel 89",0,"4",4,"Rs.46767/-","Rs.3679","cash on deliver"));
        wishListModelList.add(new WishListModel(R.drawable.phone1,"pixcel 4",3,"4",34,"Rs.46767/-","Rs.3679","cash on deliver"));
        wishListModelList.add(new WishListModel(R.drawable.phone1,"pixcel 9",7,"4",4,"Rs.46767/-","Rs.3679","cash on deliver"));

        WishListAdapter wishListAdapter=new WishListAdapter(wishListModelList);
       wishlistRecyclerView.setAdapter(wishListAdapter);
       wishListAdapter.notifyDataSetChanged();
        return view;
    }

}
