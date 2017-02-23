package com.jasonbutwell.recyclerviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CustomRecyclerViewAdapter.ListItemClickListener {

    // Somewhere to store the fake name data
    private String[] dataItems;

    // Class variables for the recyclerview and the adapter
    private CustomRecyclerViewAdapter mAdapter;
    private RecyclerView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create some fake data
        dataItems = FakeDataHelper.generateFakeData();

        // Setup the RecyclerView
        mList = (RecyclerView) findViewById(R.id.recyclerView);
        mList.setLayoutManager(new LinearLayoutManager(this));

        // Used to improve performance
        mList.setHasFixedSize(true);

        // Setup the adapter with the data to view and the click listener
        mAdapter = new CustomRecyclerViewAdapter(dataItems, this);
        mList.setAdapter(mAdapter);
    }

    // What we want to happen when a recyclerview list item is clicked
    @Override
    public void onListItemClick(int clickedItemIndex) {
        // Just display a toast message with the index of the item clicked on for now.
        String message = "You clicked on item: "+String.valueOf(clickedItemIndex);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
