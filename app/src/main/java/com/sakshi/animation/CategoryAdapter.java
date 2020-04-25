package com.sakshi.animation;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewholder>{
    //list create krengye model class ki
    private List<CategoryModel> categoryModellist;

    public CategoryAdapter(List<CategoryModel> categoryModels) {
        this.categoryModellist = categoryModels;
    }

    @NonNull
    @Override
    public CategoryAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_item,viewGroup,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.viewholder viewholder, int position) {
        //list se har ek item niklna hai or view holder ke sath bind karna
        //first get the data from list

        String icon=categoryModellist.get(position).getCategory_icon_link();
        String name=categoryModellist.get(position).getCategoryName();
        viewholder.setCategory(name,position);


    }

    @Override
    public int getItemCount() {
        return categoryModellist.size();
    }
  public    class viewholder extends RecyclerView.ViewHolder {
         private ImageView categoryIcon;
          private TextView categoryName;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            categoryIcon=itemView.findViewById(R.id.category_icon);
            categoryName=itemView.findViewById(R.id.category_name);
        }
        private void setCategoryIcon() {
            //to access the data from database
        }
        private void setCategory(final String name, final int position){
            categoryName.setText(name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(position != 0){
                    Intent categoryIntent=new Intent(itemView.getContext(),CategoryActivity.class);
                    categoryIntent.putExtra("CategoryName",name);
                    itemView.getContext().startActivity(categoryIntent);

                }}
            });


        }

    }
}
