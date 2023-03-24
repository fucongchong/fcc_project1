package com.example.cne_shop.adapter;

import android.content.Context;

import com.example.cne_shop.base.BaseAdapter;
import com.example.cne_shop.base.BaseViewHolder;
import com.example.cne_shop.okhttp.BaseCallback;

import java.util.List;



public abstract class SimpleAdapter<T> extends BaseAdapter< T , BaseViewHolder> {

    public SimpleAdapter(Context context, List<T> mDatas, int resId) {
        super(context, mDatas, resId);
    }
    
}
