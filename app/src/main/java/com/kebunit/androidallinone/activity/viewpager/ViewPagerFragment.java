package com.kebunit.androidallinone.activity.viewpager;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kebunit.androidallinone.R;

public class ViewPagerFragment extends Fragment implements View.OnClickListener {

    private LinearLayout vpTabView;
    private LinearLayout vpIntroSlider;
    private LinearLayout vpNavBottom;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_pager_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle("");
        vpIntroSlider = view.findViewById(R.id.intro_slider);
        vpTabView = view.findViewById(R.id.vp_tab_view);
        vpNavBottom = view.findViewById(R.id.vp_nav_bottom);

        vpTabView.setOnClickListener(this);
        vpIntroSlider.setOnClickListener(this);
        vpNavBottom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.vp_tab_view :
                getFragmentManager().beginTransaction()
                        .replace(R.id.activity_container, new ViewPagerTabView())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.intro_slider :
                getFragmentManager().beginTransaction()
                        .replace(R.id.activity_container, new ViewPagerSlider())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.vp_nav_bottom :
                getFragmentManager().beginTransaction()
                        .replace(R.id.activity_container, new ViewPagerNavBottom())
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
