package com.jasonbutwell.recyclerviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CustomRecyclerViewAdapter.ListItemClickListener {

    private static final int NUMBER_OF_ITEMS_IN_GRID_ROW = 2;

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
        String[] dataItems;

        // Create some fake data
        dataItems = FakeDataHelper.generateFakeData();

        // Setup the RecyclerView
        mList = (RecyclerView) findViewById(R.id.recyclerView);

        //mList.setLayoutManager(new LinearLayoutManager(this));

        // Grid Layout
        mList.setLayoutManager(new GridLayoutManager(this,NUMBER_OF_ITEMS_IN_GRID_ROW));

        // Used to improve performance
        mList.setHasFixedSize(true);

        // Setup the adapter with the data to view and the click listener
        mAdapter = new CustomRecyclerViewAdapter(dataItems, this);
        mList.setAdapter(mAdapter);
    }

    // What we want to happen when a recyclerview list item is clicked
    @Override
    public void onListItemClick(int clickedItemIndex) {

        // If there are any other toast messages existing, cancel them
        if ( mToast != null )
            mToast.cancel();

        // Just display a toast message with the index of the item clicked on for now.
        String message = "You clicked on item: "+String.valueOf(clickedItemIndex);

        // Create new Toast message and display it
        mToast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        mToast.show();
    }
}
