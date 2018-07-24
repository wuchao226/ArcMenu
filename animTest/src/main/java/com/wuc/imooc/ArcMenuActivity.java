package com.wuc.imooc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.wuc.imooc.widget.ArcMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wuchao
 * @date: 2018/2/5 22:50
 * @desciption:
 */

public class ArcMenuActivity extends AppCompatActivity {

    private ListView mListView;
    private ArcMenu mArcMenu;
    private List<String> mDatas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arc_menu);


        initData();
        initView();
        mListView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mDatas));

        initEvent();
    }

    private void initEvent() {
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (mArcMenu.isOpen()) {
                    mArcMenu.toggleMenu(600);
                }
            }
        });

        mArcMenu.setOnMenuItemClickListener(new ArcMenu.OnMenuItemClickListener() {
            @Override
            public void onClick(View view, int pos) {
                Toast.makeText(ArcMenuActivity.this, pos + ":" + view.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        mListView = findViewById(R.id.listView);
        mArcMenu = findViewById(R.id.menu_right_bottom);
    }

    private void initData() {
        mDatas = new ArrayList<String>();

        for (int i = 'A'; i < 'Z'; i++) {
            mDatas.add((char) i + "");
        }
    }
}
