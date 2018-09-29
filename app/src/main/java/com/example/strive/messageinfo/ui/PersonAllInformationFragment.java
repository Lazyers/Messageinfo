package com.example.strive.messageinfo.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.strive.messageinfo.R;
import com.example.strive.messageinfo.entity.Node;

public class PersonAllInformationFragment extends Fragment {
    private TextView name,title,date,content,like;
    private Node node;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_personallinformation,container,false);

        name = view.findViewById(R.id.allName);
        title = view.findViewById(R.id.allTitle);
        date = view.findViewById(R.id.alldate);
        content = view.findViewById(R.id.allContent);
        like = view.findViewById(R.id.like);

        name.setText(node.getName());
        title.setText(node.getContent());
        date.setText(node.getData());
        content.setText(node.getContent());
        like.setText(node.getLike()+"人点赞");

        return view;
    }
    public void setNode(Node node){
        this.node = node;
    }
}
