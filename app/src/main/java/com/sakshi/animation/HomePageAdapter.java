package com.sakshi.animation;

import android.graphics.Color;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomePageAdapter extends RecyclerView.Adapter {

    private List<HomePageModel> homePageModelList;

    public HomePageAdapter(List<HomePageModel> homePageModelList) {
        this.homePageModelList = homePageModelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (homePageModelList.get(position).getType()) {
            case 0:
                return HomePageModel.BANNER_SLIDER;
            case 1:
                return HomePageModel.STRIP_ADDD_BANNER;
            case 2:
                return HomePageModel.HORIZONTAL_PRODUCT_VIEW;
           case 3:
                return HomePageModel.GRID_PRODUCT_VIEW;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case HomePageModel.BANNER_SLIDER:
                View banner_slider_view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sliding_add_banner, viewGroup, false);
                return new BannerSliderViewHolder(banner_slider_view);
            case HomePageModel.STRIP_ADDD_BANNER:
                View strip_add_view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.strip_add_layout, viewGroup, false);
                return new StripAddBannerViewHolder(strip_add_view);
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                View horizontal_product_view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_scroll_layout, viewGroup, false);
                return new HorizontalProductViewHolder(horizontal_product_view);
            case HomePageModel.GRID_PRODUCT_VIEW:
                View grid_product_view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_product_layout, viewGroup, false);
                return new GridProductViewHolder(grid_product_view);

            default:
                return null;

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (homePageModelList.get(position).getType()) {
            case HomePageModel.BANNER_SLIDER:
                List<SliderModel> sliderModelList = homePageModelList.get(position).getSliderModelList();
                ((BannerSliderViewHolder) viewHolder).setBannerSliderViewPager(sliderModelList);
                break;
                case HomePageModel.STRIP_ADDD_BANNER:
                    int resource=homePageModelList.get(position).getResource();
                    String color=homePageModelList.get(position).getBackgroundColor();
                ((StripAddBannerViewHolder) viewHolder).setStripAdd(resource,color);
                break;
            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                String horizontal_title=homePageModelList.get(position).getTitle();
                List<HorizontalProductScrollModelClass> horizontalProductScrollModelClassList=homePageModelList.get(position).getHorizontalProductScrollModelClassList();
                ((HorizontalProductViewHolder) viewHolder).setHorizontalProductLayout(horizontalProductScrollModelClassList,horizontal_title);
                break;
            case HomePageModel.GRID_PRODUCT_VIEW:
                String grid_title=homePageModelList.get(position).getTitle();
                List<HorizontalProductScrollModelClass> GridProductScrollModelClassList=homePageModelList.get(position).getHorizontalProductScrollModelClassList();
                ((GridProductViewHolder) viewHolder).setGridProductLayout(GridProductScrollModelClassList,grid_title);
                break;
            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return homePageModelList.size();
    }


    public class BannerSliderViewHolder extends RecyclerView.ViewHolder {

        private ViewPager bannerSliderViewPager;
        private int currentPage = 2;
        private Timer timer;
        final private long DELAY_TIME = 3000;
        final private long PERIOD_TIME = 3000;


        public BannerSliderViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerSliderViewPager = itemView.findViewById(R.id.banner_slider_viewpager);


        }

        // when user touch the banner to slide after  untouch to the banner retake its slider position and slide again
        private void setBannerSliderViewPager(final List<SliderModel> sliderModelList) {
            SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
            bannerSliderViewPager.setAdapter(sliderAdapter);
            bannerSliderViewPager.setClipToPadding(false);
            bannerSliderViewPager.setPageMargin(20);

            bannerSliderViewPager.setCurrentItem(currentPage);

            // page listener
            ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {
                }

                @Override
                public void onPageSelected(int i) {
                    currentPage = i;
                }

                @Override
                public void onPageScrollStateChanged(int i) {
                    if (i == ViewPager.SCROLL_STATE_IDLE) ;
                    {
                        pageLooper(sliderModelList);
                    }
                }
            };

            bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);
            startBannerSlideShow(sliderModelList);
            bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    pageLooper(sliderModelList);
                    stopBannerSlideShow();
                    //actio up means user in untouch & ACTIO DOWN touch the slide
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        startBannerSlideShow(sliderModelList);
                    }
                    return false;
                }
            });

        }
        private void pageLooper(List<SliderModel> sliderModelList) {
            if (currentPage == sliderModelList.size() - 2) {
                currentPage = 2;
                bannerSliderViewPager.setCurrentItem(currentPage, false);

            }
            if (currentPage == 1) {
                currentPage = sliderModelList.size() - 3;
                bannerSliderViewPager.setCurrentItem(currentPage, false);

            }
        }
        // mannully slide the banner
        private void startBannerSlideShow(final List<SliderModel> sliderModelList) {
            final Handler handler = new Handler();
            final Runnable update = new Runnable() {
                @Override
                public void run() {
                    if (currentPage >= sliderModelList.size()) {
                        currentPage = 1;
                    }
                    bannerSliderViewPager.setCurrentItem(currentPage++, true);
                }
            };
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(update);
                }
            }, DELAY_TIME, PERIOD_TIME);
        }
        private void stopBannerSlideShow() {
            timer.cancel();
        }
        ////banner

    }


    ///////////////////////////              Strip  Layout                     //////////////////////////////////////////////
    public class StripAddBannerViewHolder extends RecyclerView.ViewHolder {

        private ImageView stripImage;
        private ConstraintLayout strip_container;

        public StripAddBannerViewHolder(@NonNull View itemView) {
            super(itemView);
            strip_container = itemView.findViewById(R.id.strip_add_container);
            stripImage = itemView.findViewById(R.id.strip_add_image);
        }

        private void setStripAdd(int resource1,String color1) {
            stripImage.setImageResource(resource1);
            strip_container.setBackgroundColor(Color.parseColor(color1));

        }
    }

    ///////////////////////////              Strip  Layout                     //////////////////////////////////////////////


    ///////////////////////////               horizontalLayout                       //////////////////////////////////////////////
    public class HorizontalProductViewHolder extends RecyclerView.ViewHolder {

        private TextView horizontal_layout_title;
        private Button horizontal_view_all_button;
        private RecyclerView horizontal_scroll_recyclerView;

        public HorizontalProductViewHolder(@NonNull View itemView) {
            super(itemView);
            horizontal_scroll_recyclerView=itemView.findViewById(R.id.horizontal_scroll_layout_recuclerView);
            horizontal_layout_title=itemView.findViewById(R.id.horizontal_scroll_layout_title);
            horizontal_view_all_button=itemView.findViewById(R.id.horizontal_scroll_layout_viewAll);

        }
        private void setHorizontalProductLayout(List<HorizontalProductScrollModelClass> horizontalProductScrollModelClassList,String title){

            horizontal_layout_title.setText(title);

            if(horizontalProductScrollModelClassList.size()>8){
                horizontal_view_all_button.setVisibility(View.VISIBLE);
            }else {
                horizontal_view_all_button.setVisibility(View.INVISIBLE);
            }

            HorizontalProductScrollAdapter horizontalProductScrollAdapter=new HorizontalProductScrollAdapter(horizontalProductScrollModelClassList);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            horizontal_scroll_recyclerView.setLayoutManager(linearLayoutManager);

            horizontal_scroll_recyclerView.setAdapter(horizontalProductScrollAdapter);
            horizontalProductScrollAdapter.notifyDataSetChanged();

        }
    }


    ///////////////////////////        Grid product Layout                     //////////////////////////////////////////////
    public class  GridProductViewHolder extends RecyclerView.ViewHolder {
        private TextView gridLayoutTitle;
      private   Button gridLayoutViewall;
     private GridView gridView;
        public GridProductViewHolder(@NonNull View itemView) {
            super(itemView);
             gridLayoutTitle=itemView.findViewById(R.id.grid_product_layout_title);
             gridLayoutViewall=itemView.findViewById(R.id.grid_product_layout_viewAll);
             gridView=itemView.findViewById(R.id.grid_product_layout_gridView);
        }
        private  void setGridProductLayout(List<HorizontalProductScrollModelClass> horizontalProductScrollModelClassList,String title){
            gridLayoutTitle.setText(title);
            gridView.setAdapter(new GridProductLayoutAdapter(horizontalProductScrollModelClassList));
        }

}


///////////////////////////             Grid Product Layout                     //////////////////////////////////////////////


}
