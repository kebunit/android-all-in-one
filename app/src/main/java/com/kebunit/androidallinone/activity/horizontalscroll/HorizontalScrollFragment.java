package com.kebunit.androidallinone.activity.horizontalscroll;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kebunit.androidallinone.R;
import com.kebunit.androidallinone.model.Item;

import java.util.ArrayList;

public class HorizontalScrollFragment extends Fragment {

    private ArrayList<Item> items;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setData();
    }

    private Bitmap toBitmap(int resource) {
        return BitmapFactory.decodeResource(getResources(), resource);
    }

    private void setData() {
        items = new ArrayList<>();
        items.add(new Item("Title", "Description", toBitmap(R.drawable.image_item)));
        items.add(new Item("Title", "Description", toBitmap(R.drawable.image_item)));
        items.add(new Item("Title", "Description", toBitmap(R.drawable.image_item)));
        items.add(new Item("Title", "Description", toBitmap(R.drawable.image_item)));
        items.add(new Item("Title", "Description", toBitmap(R.drawable.image_item)));
        items.add(new Item("Title", "Description", toBitmap(R.drawable.image_item)));
        items.add(new Item("Title", "Description", toBitmap(R.drawable.image_item)));
        items.add(new Item("Title", "Description", toBitmap(R.drawable.image_item)));
        items.add(new Item("Title", "Description", toBitmap(R.drawable.image_item)));
        items.add(new Item("Title", "Description", toBitmap(R.drawable.image_item)));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.horizontal_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayout container = (LinearLayout)view.findViewById(R.id.horizontal_container);
        setContent(container);
    }

    private void setContent(LinearLayout container) {
        container.removeAllViews();
        for (int i=0; i<items.size(); i++) {
            View itemView = getLayoutInflater().inflate(R.layout.horizontal_item, null);
            ImageView image = (ImageView)itemView.findViewById(R.id.image);
            TextView title = (TextView)itemView.findViewById(R.id.title);
            TextView description = (TextView)itemView.findViewById(R.id.description);
            CardView itemClick = (CardView)itemView.findViewById(R.id.item_click);

            image.setImageBitmap(items.get(i).getImage());
            title.setText(items.get(i).getTitle());
            description.setText(items.get(i).getDescription());

            final  String message = "item - "+i;
            itemClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
                }
            });

            container.addView(itemView);
        }
    }
}
