package com.example.strive.messageinfo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.example.strive.messageinfo.R;

import java.util.List;

public class FunctionAdapter extends PagerAdapter {
    private Context mContext;
    private List<String> list;
    private  View view;
    public FunctionAdapter(Context mContext,List<String> list) {
        this.mContext = mContext;
        this.list = list;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        if("one".equals(list.get(position))){
            view = View.inflate(mContext, R.layout.page,null);
        }else if("two".equals(list.get(position))){
            view = View.inflate(mContext,R.layout.page1,null);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
