package com.sakshi.animation;

import java.util.List;

public class HomePageModel {

    private int type;
    public static final int BANNER_SLIDER=0;
    public static final int STRIP_ADDD_BANNER=1;
    public static final int HORIZONTAL_PRODUCT_VIEW=2;
    public static final int GRID_PRODUCT_VIEW=3;


    ////////-------> Banner Slider <-----------------//////////
    private List<SliderModel> sliderModelList;
    public HomePageModel(int type, List<SliderModel> sliderModelList) {
        this.type = type;
        this.sliderModelList = sliderModelList;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public List<SliderModel> getSliderModelList() {
        return sliderModelList;
    }
    public void setSliderModelList(List<SliderModel> sliderModelList) {
        this.sliderModelList = sliderModelList;
    }

    ////////-------> Banner Slider <-----------------//////////

    /////-------> Strip Add Banner Slider <-----------------//////////
    private  int resource;
    private String backgroundColor;

    public HomePageModel(int type, int resource, String backgroundColor) {
        this.type = type;
        this.resource = resource;
        this.backgroundColor = backgroundColor;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    /////-------> Strip Add Banner Slider <-----------------//////////

    ////////-------> Horizontal_scroll view   && grid product layout<-----------------//////////
    private String title;
    private List<HorizontalProductScrollModelClass> horizontalProductScrollModelClassList;

    public HomePageModel(int type, String title, List<HorizontalProductScrollModelClass> horizontalProductScrollModelClassList) {
        this.type = type;
        this.title = title;
        this.horizontalProductScrollModelClassList = horizontalProductScrollModelClassList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<HorizontalProductScrollModelClass> getHorizontalProductScrollModelClassList() {
        return horizontalProductScrollModelClassList;
    }

    public void setHorizontalProductScrollModelClassList(List<HorizontalProductScrollModelClass> horizontalProductScrollModelClassList) {
        this.horizontalProductScrollModelClassList = horizontalProductScrollModelClassList;
    }
    ////////-------> Horizontal_scroll view<-----------------/////////

    ///////////---------------------- Grid product Layout  --------------////////////////
    //no need to create the construct as we use the same view
    ////////--------------------------Grid product Layout  --------------//////////////

}
