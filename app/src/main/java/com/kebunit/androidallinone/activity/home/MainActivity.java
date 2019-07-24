package com.kebunit.androidallinone.activity.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kebunit.androidallinone.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<MainItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout container = (LinearLayout)findViewById(R.id.container);
        setItems();
        setView(container);
    }

    private Bitmap toBmp(int resource) {
        return BitmapFactory.decodeResource(getResources(), resource);
    }

    private void setItems() {
        items = new ArrayList<>();
        items.add(new MainItem("Basic Layout", toBmp(R.drawable.grid), "basiclayout.BasicLayoutActivity"));
        items.add(new MainItem("Grid View", toBmp(R.drawable.grid), "gridview.GridViewActivity"));
        items.add(new MainItem("List View", toBmp(R.drawable.list), "listview.ListViewActivity"));
        items.add(new MainItem("Recycler View", toBmp(R.drawable.grid), "recyclerview.RecyclerViewActivity"));
        items.add(new MainItem("Horizontal Scroll", toBmp(R.drawable.list), "horizontalscroll.HorizontalScrollActivity"));
        items.add(new MainItem("Popup View", toBmp(R.drawable.list), "popup.PopupActivity"));
        items.add(new MainItem("QR Code Generator ", toBmp(R.drawable.list), "qrcode.QrGeneratorActivity"));
        items.add(new MainItem("View Pager ", toBmp(R.drawable.list), "viewpager.ViewPagerActivity"));
        items.add(new MainItem("Currency Format Number", toBmp(R.drawable.list), "currency.FormatNumberActivity"));
    }


    private void setView(LinearLayout container) {
        container.removeAllViews();
        for (int i=0; i<items.size(); i++) {
            View child = getLayoutInflater().inflate(R.layout.item_main, null);
            ImageView icon = (ImageView)child.findViewById(R.id.image);
            TextView title = (TextView)child.findViewById(R.id.title);
            LinearLayout itemClick = (LinearLayout)child.findViewById(R.id.item_click);

            icon.setImageBitmap(items.get(i).getIcon());
            title.setText(items.get(i).getTitle());

            final String className = items.get(i).getActivitiyName();
            itemClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Intent intent = new Intent(MainActivity.this, Class.forName(className));
                        startActivity(intent);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });

            container.addView(child);
        }
    }

    private class MainItem {
        private String title;
        private Bitmap icon;
        private String activitiyName;

        public MainItem(String title, Bitmap icon, String activitiyName) {
            this.title = title;
            this.icon = icon;
            this.activitiyName = activitiyName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Bitmap getIcon() {
            return icon;
        }

        public void setIcon(Bitmap icon) {
            this.icon = icon;
        }

        public String getActivitiyName() {
            return "com.kebunit.androidallinone.activity." + activitiyName;
        }

        public void setActivitiyName(String activitiyName) {
            this.activitiyName = activitiyName;
        }
    }
}
