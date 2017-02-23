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

    private String[] dataItems;

    public CustomRecyclerViewAdapter(String [] dataItems) {
        this.dataItems = dataItems;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.list_item;
        boolean shouldAttachToParentImmediately = false;

        return new CustomViewHolder( LayoutInflater.from(context).inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately) );
    }

    @Override
    public void onBindViewHolder(CustomRecyclerViewAdapter.CustomViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return dataItems.length;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView listItemNumberView;

        public CustomViewHolder(View itemView) {
            super(itemView);

            listItemNumberView = (TextView) itemView.findViewById(R.id.tv_item);
        }

        void bind(int listIndex) {
            listItemNumberView.setText(dataItems[listIndex]);
        }

    }
}
