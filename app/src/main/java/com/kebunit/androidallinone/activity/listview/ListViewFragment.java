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
        icons.add(new Icon(R.drawable.icon, "Motorcycle", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.icon, "Computer", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.icon, "Car", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.icon, "Bicycle", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.icon, "Home", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.icon, "Life", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.icon, "Room", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.icon, "Mountain", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.icon, "Sea", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.icon, "Beach", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.icon, "Building", "Modern transportation lorem ipsum isr amet"));
        icons.add(new Icon(R.drawable.icon, "Road", "Modern transportation lorem ipsum isr amet"));
    }
}
