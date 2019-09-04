package com.kebunit.androidallinone.activity.searchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.kebunit.androidallinone.R;

import java.util.ArrayList;

public class SearchViewActivity extends AppCompatActivity {

    // Declare Variables
    ListView list;
    SearchAdapter adapter;
    SearchView editsearch;
    String[] searchQueries;
    ArrayList<SearchAdapter.QueryItem> arraylist = new ArrayList<SearchAdapter.QueryItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Search View");

        setContentView(R.layout.activity_search_view);

        searchQueries = new String[]{"TextView", "ListView", "SearchView",
                "RatingBar", "ToolBar", "Button", "EditText", "ToggleButton",
                "ImageView","SlidingDrawer","Android"};

        list = (ListView) findViewById(R.id.list_view);
        for (String searchQuery:searchQueries) {
            SearchAdapter.QueryItem item = new SearchAdapter.QueryItem(searchQuery, R.drawable.icon);
            // Binds all strings into an array
            arraylist.add(item);
        }
        adapter = new SearchAdapter(this, arraylist);
        list.setAdapter(adapter);
        editsearch = (SearchView) findViewById(R.id.search_view);
        editsearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                String text = newText;
                adapter.filter(text);
                return false;
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SearchViewActivity.this, "Selected : " + searchQueries[position], Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()== android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return false;
        }
    }
}
