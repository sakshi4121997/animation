package com.sakshi.animation.products;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.sakshi.animation.R;

public class AddressActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button savebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        savebtn=findViewById(R.id.address_save_btn);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Add a new Address");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliverIntent=new Intent(AddressActivity.this,DeliverActivity.class);
                startActivity(deliverIntent);
                finish();
            }
        });
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
