package com.example.strive.messageinfo.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.strive.messageinfo.R;
import com.example.strive.messageinfo.adapter.CommentListAdapter;
import com.example.strive.messageinfo.entity.Node;

public class PersonAllInformationFragment extends Fragment implements View.OnClickListener {
    public TextView name,title,date,content,like;
    private Node node;
    private RecyclerView commentList;
    public CommentListAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_personallinformation,container,false);

        name = view.findViewById(R.id.allName);
        title = view.findViewById(R.id.allTitle);
        date = view.findViewById(R.id.alldate);
        content = view.findViewById(R.id.allContent);
        like = view.findViewById(R.id.like);
        commentList = view.findViewById(R.id.CommentList);
        name.setText(node.getName());
        title.setText(node.getContent());
        date.setText(node.getData());
        content.setText(node.getContent());
        like.setText(node.getLike()+"人点赞");
        name.setOnClickListener(this);

        commentList.setLayoutManager(new LinearLayoutManager(
                getActivity(),LinearLayoutManager.VERTICAL,false));
        adapter = new CommentListAdapter();
        adapter.setData(node.getCommentInfoList());
        commentList.addItemDecoration(new DividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL));
        commentList.setAdapter(adapter);

        return view;
    }
    public void setNode(Node node){
        this.node = node;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.allName :
                Toast.makeText(getActivity(), "打开个人信息页面", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
