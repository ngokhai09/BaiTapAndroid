package com.example.bt2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Activity activity;
    ArrayList<Contact> data;
    LayoutInflater inflater;

    public MyAdapter(Activity activity, ArrayList<Contact> data) {
        this.activity = activity;
        this.data = data;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return data.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if(v == null){
            v = inflater.inflate(R.layout.list_items, null);
            TextView txtFullname = v.findViewById(R.id.txtFullname);
            txtFullname.setText(data.get(i).getName());
            TextView txtNumber = v.findViewById(R.id.txtNumber);
            txtNumber.setText(data.get(i).getNumber());
            CheckBox checkBox = v.findViewById(R.id.checkBox);
            checkBox.setChecked(false);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        data.get(i).setStatus(true);
                    }
                    else{
                        data.get(i).setStatus(false);
                    }
                }
            });
        }
        return v;
    }
}
