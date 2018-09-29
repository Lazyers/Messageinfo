package com.example.strive.messageinfo;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.strive.messageinfo.entity.Node;
import com.example.strive.messageinfo.mvp.MessagePresenter;
import com.example.strive.messageinfo.mvp.MessageView;

import java.util.ArrayList;
import java.util.List;

// todo Java文件应该根据功能的不同放在不同的包里
/**
 * com.example.strive.messageinfo下有如下包：
 *
 * ui : 放 activity 和 fragment
 *
 * adapter:
 *
 * mvp:
 *      view:
 *      presenter:
 *      model:
 *
 * entity: 数据源类
 *
 * Custom：自定义view
 *
 *
 *
 *
 */

public class MainActivity extends AppCompatActivity implements MessageView {
    MessagePresenter messagePresenter;
    RecyclerView recyclerView;
    MessageAdapter adapters;
    SwipeRefreshLayout swipeRefreshLayout;
    List<Node> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messagePresenter = new MessagePresenter();
        messagePresenter.attachView(this);
        recyclerView = findViewById(R.id.MessageRecycle);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeColors(Color.BLUE);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                adapters.setFootstat(2);
                adapters.clear();
                messagePresenter.getData(1);
            }
        });
        recyclerView.setLayoutManager(
                new LinearLayoutManager(
                        this,
                        LinearLayoutManager.VERTICAL,
                        false));
        adapters = new MessageAdapter(this);
        adapters.setOnItemClickListener(new MessageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Node data) {
                Toast.makeText(MainActivity.this, "点击了", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapters);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager linearLayoutManager =
                        (LinearLayoutManager) recyclerView.getLayoutManager();
                int lastItem = linearLayoutManager.findLastVisibleItemPosition();
                if(newState == recyclerView.SCROLL_STATE_IDLE &&
                        lastItem + 1 == adapters.getItemCount()){
                        adapters.clear();
                        messagePresenter.getData(2);
                }
            }
        });
        messagePresenter.getData(1);
    }
    @Override
    public void showData(List<Node> nodeList) {
        adapters.setList(nodeList);
        swipeRefreshLayout.setRefreshing(false);
    }
    @Override
    public void showFailureMessage(String msg) {
        //提示失败
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        messagePresenter.detachView();
        swipeRefreshLayout.setRefreshing(false);
    }
}
