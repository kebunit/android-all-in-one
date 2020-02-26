package com.kebunit.androidallinone.activity.searchview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kebunit.androidallinone.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchAdapter extends BaseAdapter {
    private Context context;
    private List<QueryItem> items;
    private ArrayList<QueryItem> queryItems;

    public SearchAdapter(Context context, List<QueryItem> items) {
        this.context = context;
        this.items = items;
        this.queryItems = new ArrayList<QueryItem>();
        this.queryItems.addAll(items);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View child = LayoutInflater.from(context).inflate(R.layout.list_items, parent, false);
        ImageView image = child.findViewById(R.id.image);
        TextView name = child.findViewById(R.id.name);
        name.setText(items.get(position).getName());
        image.setImageResource(items.get(position).getImage());
        return child;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        items.clear();
        if (charText.length() == 0) {
            items.addAll(queryItems);

        } else {
            for (QueryItem item : queryItems) {
                if (item.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    items.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

    // INNER CLASS ITEM
    public static class QueryItem {
        private String name;
        private int image;

        public QueryItem(String name, int image) {
            this.name = name;
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }
    }

}