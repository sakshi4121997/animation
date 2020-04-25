package com.sakshi.animation.products;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sakshi.animation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDiscriptionFragment extends Fragment {


    public ProductDiscriptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_discription, container, false);
    }

}
