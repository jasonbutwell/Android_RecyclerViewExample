package com.jasonbutwell.recyclerviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListItemClickListener {

    //private static final int NUMBER_OF_ITEMS_IN_GRID_ROW = 2;

    // Class variables for the RecyclerView and the adapter
    private CustomRecyclerViewAdapter mAdapter;
    private RecyclerView mList;

    // Class variable to store current Toast message so we can cancel it with a new one
    private static Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Somewhere to store the fake name data
        ArrayList<String> dataItems;

        // Create some fake data
        dataItems = FakeDataHelper.generateFakeData();

        // Setup the RecyclerView
        mList = (RecyclerView) findViewById(R.id.recyclerView);

        // Grid Layout
        //mList.setLayoutManager(new GridLayoutManager(this,NUMBER_OF_ITEMS_IN_GRID_ROW));

        // Uncomment this line to present the data as a Linear Layout
        mList.setLayoutManager(new LinearLayoutManager(this));

        // Used to improve performance - (Should only use this if views are fixed size)
        mList.setHasFixedSize(true);

        // Setup the adapter with the data to view and the click listener
        mAdapter = new CustomRecyclerViewAdapter(dataItems, this);
        mList.setAdapter(mAdapter);

        // Add some more data here to our list

        dataItems.add("Bob Hope");
        dataItems.add("Dan Alexander");
        dataItems.add("Hugh Goh");

        // We can change the data set by calling setData method on our adapter
        mAdapter.setData(dataItems);
    }

    // What we want to happen when a Recyclerview list item is clicked
    @Override
    public void onListItemClick(int clickedItemIndex) {

        // If there are any other toast messages existing, cancel them
        if ( mToast != null ) mToast.cancel();

        // Just display a toast message with the index of the item clicked on for now.
        String message = "You clicked on item #" + String.valueOf(clickedItemIndex);

        // Create new Toast message and display it
        mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        mToast.show();
    }
}
