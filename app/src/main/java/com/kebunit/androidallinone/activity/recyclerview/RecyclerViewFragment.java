package com.kebunit.androidallinone.activity.recyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kebunit.androidallinone.R;
import com.kebunit.androidallinone.model.Icon;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Icon> icons;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view_fragment, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        setIcons();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), icons);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void setIcons() {
        icons = new ArrayList<>();
        icons.add(new Icon(R.drawable.icon, "Jual"));
        icons.add(new Icon(R.drawable.icon, "Beli"));
        icons.add(new Icon(R.drawable.icon, "Tawar"));
        icons.add(new Icon(R.drawable.icon, "Lelang"));
        icons.add(new Icon(R.drawable.icon, "Nego"));
        icons.add(new Icon(R.drawable.icon, "Agan"));
        icons.add(new Icon(R.drawable.icon, "Chat"));
        icons.add(new Icon(R.drawable.icon, "Beri"));
        icons.add(new Icon(R.drawable.icon, "Sedekah"));
        icons.add(new Icon(R.drawable.icon, "Diskon"));
        icons.add(new Icon(R.drawable.icon, "Cashback"));
    }
}
