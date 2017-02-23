package com.jasonbutwell.recyclerviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private String[] dataItems;

    private CustomRecyclerViewAdapter mAdapter;
    private RecyclerView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataItems = FakeDataHelper.generateFakeData();

        mList = (RecyclerView) findViewById(R.id.recyclerView_id);
        mList.setLayoutManager(new LinearLayoutManager(this));
        mList.setHasFixedSize(true);

        mAdapter = new CustomRecyclerViewAdapter(dataItems);
        mList.setAdapter(mAdapter);
    }
}
