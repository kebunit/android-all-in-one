package com.kebunit.androidallinone.activity.recyclerview;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kebunit.androidallinone.R;
import com.kebunit.androidallinone.model.Icon;

import java.util.ArrayList;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RvViewHolder>{
    private Context context;
    private ArrayList<Icon> icons;

    public RecyclerViewAdapter(Context context, ArrayList<Icon> icons) {
        this.context = context;
        this.icons = icons;
    }

    @NonNull
    @Override
    public RvViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_grid_view, viewGroup, false);
        return new RvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvViewHolder holder, int i) {
        holder.title.setText(icons.get(i).getTitle());
        holder.icon.setImageResource(icons.get(i).getIcon());
        holder.clicked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return icons.size();
    }

    public class RvViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon;
        LinearLayout  clicked;
        public RvViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.icon_title);
            icon = (ImageView)itemView.findViewById(R.id.icon_image);
            clicked = (LinearLayout)itemView.findViewById(R.id.icon_click);
        }
    }
}
