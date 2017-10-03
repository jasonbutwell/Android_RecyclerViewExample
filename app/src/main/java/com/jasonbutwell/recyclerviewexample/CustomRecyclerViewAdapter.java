package com.jasonbutwell.recyclerviewexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by J on 23/02/2017.
 */

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    // Class variable to store the data to show
    private ArrayList<String> dataItems;

    // Somewhere to store the click list item listener
    private ListItemClickListener mOnClickListener;

    // Recycler constructor, stores the data and the list item click listener to use
    CustomRecyclerViewAdapter(ArrayList<String> dataItems, ListItemClickListener listener) {
        setData( dataItems );
        mOnClickListener = listener;
    }

    // Added so we can modify the dataset for the adapter at will
    // We must call notifyDataSetChanged() after we modify the dataset so the adapter updates accordingly

    public void setData( ArrayList<String> dataItems ) {
        this.dataItems = dataItems;
        notifyDataSetChanged();
    }

    // This is our view holder that inflates our list item layout for us
    // Note we can tweak this to show different layouts for different types of items if we want
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        boolean shouldAttachToParentImmediately = false;

        // Inflate a view from our custom layout list_item.xml
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, shouldAttachToParentImmediately);

        // return a new CustomViewHolder for that View
        return new CustomViewHolder(view, mOnClickListener);
    }

    // Calls our view holder with the position of the item to show
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        // Calls the view Holders bind method passing in the data item to bind
        holder.bind(dataItems.get(position));
    }

    // Returns back the number of items to show
    @Override
    public int getItemCount() {
        return dataItems.size();
    }
}
