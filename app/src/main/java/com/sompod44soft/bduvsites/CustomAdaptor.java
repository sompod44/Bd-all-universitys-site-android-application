package com.sompod44soft.bduvsites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sompod_Programmer on 11/22/2017.
 */
// This class java for custom adaptor

public class CustomAdaptor extends BaseAdapter {

    String[] Universitys;
    Context context;
    private LayoutInflater inflater;

    CustomAdaptor(Context context, String[] Universitys) {
        this.context = context;
        this.Universitys = Universitys;
    }

    @Override
    public int getCount() {
        return Universitys.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) { //View view mean Convert View int i mean position
        if (view == null) {
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.sample_layout, viewGroup, false);
        }
        TextView textView = view.findViewById(R.id.sampletextviewid1);
        textView.setText(Universitys[i]);
        return view;
    }
}
