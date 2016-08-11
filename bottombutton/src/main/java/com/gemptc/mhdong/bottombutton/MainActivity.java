package com.gemptc.mhdong.bottombutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    List<String> mList;
    ArrayAdapter<String> mAdapter;
    int lastIndex;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initData();
        addlistener();
    }

    private void initViews() {
        mListView = (ListView) findViewById(R.id.lv);
        mButton = (Button) findViewById(R.id.button);
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 1; i < 16; i++){
            mList.add("字段" + i);
        }
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mList);
        mListView.setAdapter(mAdapter);
    }

    private void addlistener() {
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState){
                    case SCROLL_STATE_IDLE:
                        if (lastIndex == mList.size()){
                            mButton.setVisibility(View.VISIBLE);
                        } else {
                            mButton.setVisibility(View.GONE);
                        }
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                lastIndex = firstVisibleItem + visibleItemCount;
            }
        });
    }
}
