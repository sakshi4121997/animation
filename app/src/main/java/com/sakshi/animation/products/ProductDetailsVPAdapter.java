package com.sakshi.animation.products;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ProductDetailsVPAdapter extends FragmentPagerAdapter {
    private  int totalTabs;
    public ProductDetailsVPAdapter(FragmentManager fm,int totalTabs) {
        super(fm);
        this.totalTabs=totalTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                 ProductDiscriptionFragment productDiscriptionFragment1=new ProductDiscriptionFragment();
                 return  productDiscriptionFragment1;
            case 1:
              ProductSpecificationFragment productSpecificationFragment=new ProductSpecificationFragment();
              return  productSpecificationFragment;
            case 2:
                ProductDiscriptionFragment productDiscriptionFragment2=new ProductDiscriptionFragment();
                return productDiscriptionFragment2;
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs ;
    }
}
