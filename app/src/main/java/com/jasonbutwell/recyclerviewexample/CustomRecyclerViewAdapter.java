package com.jasonbutwell.recyclerviewexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by J on 23/02/2017.
 */

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomViewHolder> {

    // Class variable to store the data to show
    private String[] dataItems;

    // Somewhere to store the click list item listener
    final private ListItemClickListener mOnClickListener;

    // A method we must implement
    public interface ListItemClickListener {
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

        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.list_item;
        boolean shouldAttachToParentImmediately = false;

        return new CustomViewHolder( LayoutInflater.from(context).inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately) );
    }

    // Calls our view holder with the position of the item to show

    @Override
    public void onBindViewHolder(CustomRecyclerViewAdapter.CustomViewHolder holder, int position) {
        holder.bind(position);
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

    // The custom view holder inner class, used for assigning data to views

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView listItemView;  // location for the view we want to change

        public CustomViewHolder(View itemView) {
            super(itemView);

            // Get a reference to the view to change
            listItemView = (TextView) itemView.findViewById(R.id.tv_item_Name);

            // set our click listener to respond to that view item
            itemView.setOnClickListener(this);
        }

        // Binding of data from our view holder which will set the view being looked at to the data we want

        void bind(int position) {
            listItemView.setText(dataItems[position]);
        }

        // Our internal click handler that signifies what item was actually clicked

        @Override
        public void onClick(View view) {
            mOnClickListener.onListItemClick(getAdapterPosition());
        }
    }
}
