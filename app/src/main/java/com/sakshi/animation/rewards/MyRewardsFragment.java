package com.sakshi.animation.rewards;

import android.content.Context;
import android.net.Uri;
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

public class MyRewardsFragment extends Fragment {
    private RecyclerView rewardRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_rewards, container, false);
        rewardRecyclerView=view.findViewById(R.id.reward_recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rewardRecyclerView.setLayoutManager(linearLayoutManager);

        List<RewardModel> rewardModelList=new ArrayList<>();
        rewardModelList.add(new RewardModel("hello","12,dec,2020","GET 20% OFF Oon any product above Rs. 500/- and below Rs.2500/-"));
        rewardModelList.add(new RewardModel("hiiiiiii","12,dec,2020","GET 20% OFF Oon any product above Rs. 500/- and below Rs.2500/-"));
        rewardModelList.add(new RewardModel("hello","12,dec,2020","GET 20% OFF Oon any product above Rs. 500/- and below Rs.2500/-"));
        rewardModelList.add(new RewardModel("nkkkkklk","12,dec,2020","GET 20% OFF Oon any product above Rs. 500/- and below Rs.2500/-"));
        rewardModelList.add(new RewardModel("hello","12,dec,2020","GET 20% OFF Oon any product above Rs. 500/- and below Rs.2500/-"));
        RewardAdapter adapter=new RewardAdapter(rewardModelList);
        rewardRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        return view;
    }


}
