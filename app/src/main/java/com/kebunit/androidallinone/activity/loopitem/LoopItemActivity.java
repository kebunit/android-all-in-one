package com.kebunit.androidallinone.activity.loopitem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.vision.text.Line;
import com.kebunit.androidallinone.R;

import java.util.ArrayList;

public class LoopItemActivity extends AppCompatActivity {
    private LinearLayout mainContainer;
    private ArrayList<LoopItem> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop_item);
        mainContainer = findViewById(R.id.container_parent);

        setMainContainer();
    }

    private void setMainContainer() {
        mainContainer.removeAllViews();
        setItem();
        int idx = 0;
        for(LoopItem item : items) {
            View mainView = getLayoutInflater().inflate(R.layout.loop_main, mainContainer, false);
            TextView title = mainView.findViewById(R.id.title);
            LinearLayout itemClick = mainView.findViewById(R.id.item_click);
            final ImageView itemIndicator = mainView.findViewById(R.id.image_indicator);
            final LinearLayout itemContainer = mainView.findViewById(R.id.container_item);
            itemContainer.setVisibility(View.GONE);
            itemClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemContainer.getVisibility() == View.GONE) {
                        itemContainer.setVisibility(View.VISIBLE);
                        itemIndicator.setRotation(90);
                    } else {
                        itemContainer.setVisibility(View.GONE);
                        itemIndicator.setRotation(270);
                    }

                }
            });

            title.setText(item.getTitle());
            int number = 0;
            for (String str : item.getContent()) {
                View childView = getLayoutInflater().inflate(R.layout.loop_child, null);
                TextView tvNumber = childView.findViewById(R.id.number);
                TextView tvSubContent = childView.findViewById(R.id.sub_content);
                tvNumber.setText(""+(number+1));
                tvSubContent.setText(str);
                itemContainer.addView(childView);
                number++;
            }
            mainContainer.addView(mainView);
        }
    }

    private void setItem() {
        items = new ArrayList<>();
        String[] str = {
                "Kunjungajhakj ahdahdhajkhdjadhahda dajdahjkdada asdhhad adhadkahdkada dahskdjhadk adkahd kahdka dhkadhak dh",
                "akshdkad adshsakdjhs akdhakdhkajdhak dhajkdhajkd",
                "ashdkjahdk adkahdkadhkadhkaj hdskajhdskah dssad",
                "kajdhkasjdhsa dhakjdh akd hsak dhkadhkjahdkahdk jah"
        };

        items.add(new LoopItem("ATM", str));
        items.add(new LoopItem("Teller Bank", str));
        items.add(new LoopItem("Internet Banking", str));
        items.add(new LoopItem("Post", str));
    }
}
