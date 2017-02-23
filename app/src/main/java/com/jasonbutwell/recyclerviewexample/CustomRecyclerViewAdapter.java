package com.jasonbutwell.recyclerviewexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by J on 23/02/2017.
 */

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    // Class variable to store the data to show
    private String[] dataItems;

    // Somewhere to store the click list item listener
    private final ListItemClickListener mOnClickListener;

    // A method we must implement
    interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    // Recycler constructor, stores the data and the list item click listener to use
    public CustomRecyclerViewAdapter(String [] dataItems, ListItemClickListener listener) {
        this.dataItems = dataItems;
        mOnClickListener = listener;
    }

    // This is our view holder that inflates our list item layout for us
    // Note we can tweak this to show different layouts for different types of items if we want

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        boolean shouldAttachToParentImmediately = false;

        return new CustomViewHolder( LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, shouldAttachToParentImmediately),
                mOnClickListener );
    }

    // Calls our view holder with the position of the item to show

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.bind(dataItems[position]);
    }

    // Can be used to get the type of view

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    // Returns back the number of items to show

    @Override
    public int getItemCount() {
        return dataItems.length;
    }

    // Returns an item id

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}
