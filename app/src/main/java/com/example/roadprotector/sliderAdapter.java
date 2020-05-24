package com.example.roadprotector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class sliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;


    public int[] slide_images;


    public int[] navigation_set= {
            R.drawable.safest_route,
            R.drawable.type_destination,
            R.drawable.different_routes,
            R.drawable.route_info,
            R.drawable.rest_stop,
            R.drawable.save_route_preference,
            R.drawable.tap_on_nav_sllider,
            R.drawable.search_slider,
            R.drawable.multi_route_slider,
            R.drawable.accident_zones_slider,
            R.drawable.rest_stop_slider
    };

    public sliderAdapter(Context context, String ActivityName){
        this.context = context;
        if (ActivityName.equals("NavigationActivity")){
            slide_images = navigation_set;
        }
        else if (ActivityName.equals("ExploreActivity")){
            slide_images = navigation_set;
        }
    }



    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.imageView);

        slideImageView.setImageResource(slide_images[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((RelativeLayout) object);
    }
}
