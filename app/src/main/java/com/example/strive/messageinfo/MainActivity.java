package com.example.strive.messageinfo;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MessageView {
    MessagePresenter messagePresenter;
    RecyclerView recyclerView;
    MessageAdapters adapters;
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

//                Node node = new Node();
//                node.setImageURL(R.drawable.plxl);
//                node.setName("吴闯");
//                node.setData("2018-9-27");
//                node.setType("私有笔记>");
//                node.setContent("笔记的中心内容");
//                node.setComment(2);
//                node.setLike(2);
//                list.add(node);
//                adapters.notifyDataSetChanged();
//                swipeRefreshLayout.setRefreshing(false)

                adapters.clear();
                messagePresenter.getData();
            }
        });
        recyclerView.setLayoutManager(
                new LinearLayoutManager(
                        this,
                        LinearLayoutManager.VERTICAL,
                        false));
        adapters = new MessageAdapters(this);
        adapters.setOnItemClickListener(new MessageAdapters.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Node data) {
                Toast.makeText(MainActivity.this, "点击了", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapters);
        messagePresenter.getData();
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
