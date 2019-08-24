package com.kebunit.androidallinone.activity.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kebunit.androidallinone.R;
import com.kebunit.androidallinone.model.Icon;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Icon> iconArrayList;

    public ListViewAdapter(Context context, ArrayList<Icon> iconArrayList) {
        this.context = context;
        this.iconArrayList = iconArrayList;
    }


    @Override
    public int getCount() {
        return iconArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return iconArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_list_view, null);
        TextView title = (TextView)convertView.findViewById(R.id.title_list);
        TextView descriptiom = (TextView)convertView.findViewById(R.id.description_list);
        ImageView icon = (ImageView)convertView.findViewById(R.id.icon_list);

        title.setText(iconArrayList.get(position).getTitle());
        descriptiom.setText(iconArrayList.get(position).getDescription());
        icon.setImageResource(iconArrayList.get(position).getIcon());
        return convertView;
    }
}
