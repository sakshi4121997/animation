package com.sakshi.animation.products;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.sakshi.animation.R;

import java.util.ArrayList;
import java.util.List;

public class MyAddressActivity extends AppCompatActivity {
private Toolbar toolbar;
private RecyclerView address_recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("My Address");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        address_recyclerView=findViewById(R.id.adresses_recyclerr_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        address_recyclerView.setLayoutManager(linearLayoutManager);

        List<AddressModel> addressModelList =new ArrayList<>();
        addressModelList.add(new AddressModel("abcd","hdgfzsdgfhbnbxc","4352662"));
        addressModelList.add(new AddressModel("47734d","hdgfzsdgfhbnbxc","4362"));
        addressModelList.add(new AddressModel("ndsbjf","hdgfzsdgfhbnjdajwhfhebcjdhfjafhxc","43562"));
        addressModelList.add(new AddressModel("kdlka","hdgfzsdgfhbnbxc","8547698"));

        AddressAdapter addressAdapter=new AddressAdapter(addressModelList);
        address_recyclerView.setAdapter(addressAdapter);
        addressAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int  id = item.getItemId();
        if(id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
