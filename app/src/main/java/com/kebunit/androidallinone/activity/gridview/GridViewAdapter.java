package com.kebunit.androidallinone.activity.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kebunit.androidallinone.R;
import com.kebunit.androidallinone.model.Icon;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Icon> icons;

    public GridViewAdapter(Context context, ArrayList<Icon> icons) {
        this.context = context;
        this.icons = icons;
    }

    @Override
    public int getCount() {
        return icons.size();
    }

    @Override
    public Object getItem(int position) {
        return icons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_grid_view, null);
        TextView title = (TextView)convertView.findViewById(R.id.icon_title);
        ImageView icon = (ImageView)convertView.findViewById(R.id.icon_image);
        LinearLayout itemClicked = (LinearLayout)convertView.findViewById(R.id.icon_click);

        title.setText(icons.get(position).getTitle());
        icon.setImageResource(icons.get(position).getIcon());
        itemClicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Item Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
