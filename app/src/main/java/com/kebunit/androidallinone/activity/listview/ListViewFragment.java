package com.kebunit.androidallinone.activity.listview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kebunit.androidallinone.R;
import com.kebunit.androidallinone.model.Icon;

import java.util.ArrayList;

public class ListViewFragment extends Fragment {
    private ArrayList<Icon> icons;
    private ListView listView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_view_fragment, container, false);
        listView = (ListView)view.findViewById(R.id.list_view);
        setItemList();
        ListViewAdapter adapter = new ListViewAdapter(getContext(), icons);
        listView.setAdapter(adapter);
        return view;
    }

    private void setItemList() {
        icons = new ArrayList<>();
        icons.add(new Icon(R.drawable.image_item, "Motorcycle", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.image_item, "Computer", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.image_item, "Car", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.image_item, "Bicycle", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.image_item, "Home", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.image_item, "Life", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.image_item, "Room", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.image_item, "Mountain", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.image_item, "Sea", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.image_item, "Beach", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.image_item, "Building", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.image_item, "Road", "Modern transportation lorem ipsum isr amet"));
    }
}
