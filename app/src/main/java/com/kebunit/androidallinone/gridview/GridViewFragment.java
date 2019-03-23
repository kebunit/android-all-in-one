package com.kebunit.androidallinone.gridview;

import android.accessibilityservice.AccessibilityService;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.kebunit.androidallinone.R;
import com.kebunit.androidallinone.item.Icon;

import java.util.ArrayList;

class GridViewFragment extends Fragment {
    private GridView gridView;
    private ArrayList<Icon> icons;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_view_fragment, container, false);
        gridView = (GridView)view.findViewById(R.id.grid_view);
        setIcon();
        GridViewAdapter adapter = new GridViewAdapter(getContext(), icons);
        gridView.setAdapter(adapter);
        return view;
    }

    private void setIcon() {
        icons = new ArrayList<>();
        icons.add(new Icon(R.drawable.icon, "Home"));
        icons.add(new Icon(R.drawable.icon, "Shopping"));
        icons.add(new Icon(R.drawable.icon, "Payment"));
        icons.add(new Icon(R.drawable.icon, "Asurance"));
        icons.add(new Icon(R.drawable.icon, "Health"));
        icons.add(new Icon(R.drawable.icon, "Bill Payment"));
        icons.add(new Icon(R.drawable.icon, "Car"));
        icons.add(new Icon(R.drawable.icon, "Rental"));
        icons.add(new Icon(R.drawable.icon, "Bicycle"));
        icons.add(new Icon(R.drawable.icon, "Motorcycle"));
    }
}
