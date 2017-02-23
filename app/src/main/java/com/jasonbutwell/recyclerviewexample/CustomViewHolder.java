package com.jasonbutwell.recyclerviewexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by J on 23/02/2017.
 */

// The custom view holder outer class, used for assigning data to views

class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView listItemView;  // location for the view we want to change
    private CustomRecyclerViewAdapter.ListItemClickListener mOnClickListener;

    public CustomViewHolder(View itemView, CustomRecyclerViewAdapter.ListItemClickListener mOnClickListener) {
        super(itemView);

        // Get a reference to the view to change
        listItemView = (TextView) itemView.findViewById(R.id.tv_item_Name);
        this.mOnClickListener = mOnClickListener;

        // set our click listener to respond to that view item
        itemView.setOnClickListener(this);
    }

    // Binding of data from our view holder which will set the view being looked at to the data we want

    public void bind(String text) {
        listItemView.setText(text);
    }

    // Our internal click handler that signifies what item was actually clicked

    @Override
    public void onClick(View view) {
        mOnClickListener.onListItemClick(getAdapterPosition());
    }
}