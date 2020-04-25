package com.sakshi.animation.products;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.sakshi.animation.R;

import java.util.ArrayList;
import java.util.List;

public class DeliverActivity extends AppCompatActivity {
    private RecyclerView deliverRecyclerView;
private Button changeOrAddNewAddressBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliver);
        changeOrAddNewAddressBtn=findViewById(R.id.change_or_add_address_btn);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Delivery");
        deliverRecyclerView=findViewById(R.id.deliver_recyclerView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deliverRecyclerView.setLayoutManager(linearLayoutManager);

        List<CartItemModel> cartItemModelList=new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.lady,"pixel 24",5,"Rs676676/-","Rs.44566/-",1,0,5));
        cartItemModelList.add(new CartItemModel(0,R.drawable.phone1,"pixel 44",5,"Rs76676/-","Rs.44566/-",3,2,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.lady,"pixel 24",8,"Rs6676/-","Rs.44566/-",1,3,4));
        cartItemModelList.add(new CartItemModel(0,R.drawable.phone1,"pixel 84",5,"Rs66776/-","Rs.44566/-",8,0,6));
        cartItemModelList.add(new CartItemModel(1,"price(5 items)","RS.677/-","Free"," You saved Rs100/- on your shopping ","Rs.1667/-"));
        CartAdapter cartAdapter=new CartAdapter(cartItemModelList);
        deliverRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();
        changeOrAddNewAddressBtn.setVisibility(View.VISIBLE);
        changeOrAddNewAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myAddress=new Intent(DeliverActivity.this,MyAddressActivity.class);
                startActivity(myAddress);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

       if(id == android.R.id.home){
           finish();
           return true;
       }
        return super.onOptionsItemSelected(item);
    }
}
