package com.example.secondproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.secondproject.R;
import com.example.secondproject.model.ImageDetails;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {
    private List<ImageDetails> imageDetails;
    private LayoutInflater layoutInflater;
    private Context context;

    public ViewPagerAdapter(List<ImageDetails> imageDetails, Context context){
        this.context = context;
        this.imageDetails = imageDetails;
    }

    @Override
    public int getCount() {
        return imageDetails.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.items, container, false);

        ImageView imageView;

        imageView = view.findViewById(R.id.images);
        imageView.setImageResource(imageDetails.get(position).getImage());

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
