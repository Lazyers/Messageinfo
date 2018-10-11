package com.example.strive.messageinfo.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.strive.messageinfo.R;
import com.example.strive.messageinfo.adapter.FunctionAdapter;
import com.example.strive.messageinfo.entity.CommentInfo;
import com.example.strive.messageinfo.entity.Node;

import java.util.ArrayList;
import java.util.List;

public class PersonAllInformationActivity extends AppCompatActivity implements View.OnClickListener {
    private Node node;
    private TextView name,title,date;
    private Button bottom_like,bottom_share,face,finish,function;
    private EditText input;
    private FrameLayout frameLayout;
    private InputMethodManager imm;
    private boolean flag = true;
    private PersonAllInformationFragment fragment;
    private ViewPager viewPager;
    private boolean viewPagerFlag = true;
    List<CommentInfo> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_all_information);

        Intent intent = getIntent();
        flag = intent.getBooleanExtra("flag",true);
        Bundle bundle = intent.getExtras();
        node = (Node) bundle.getSerializable("node");
        list.addAll(node.getCommentInfoList());

        fragment = new PersonAllInformationFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.allInformation,fragment);
        transaction.commit();

        bottom_like = findViewById(R.id.bottom_like);
        bottom_share = findViewById(R.id.bottom_share);
        face = findViewById(R.id.face);
        finish = findViewById(R.id.finish);
        input = findViewById(R.id.input);
        frameLayout = findViewById(R.id.allInformation);
        function = findViewById(R.id.function);
        viewPager = findViewById(R.id.viewpage);

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        viewPager.setAdapter(new FunctionAdapter(this,list));

        input.setCursorVisible(false);
        bottom_like.setText(""+node.getLike());
        if(!flag){
            bottom_like.setBackgroundColor(Color.BLUE);
        }

        bottom_like.setOnClickListener(this);
        input.setOnClickListener(this);
        frameLayout.setOnClickListener(this);
        fragment.setNode(node);
        bottom_share.setOnClickListener(this);
        finish.setOnClickListener(this);
        face.setOnClickListener(this);
        function.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bottom_like :
                if(flag){
                    node.setLike(node.getLike()+1);
                    bottom_like.setBackgroundColor(Color.BLUE);
                    bottom_like.setText(node.getLike()+"");
                    fragment.like.setText(node.getLike()+"人点赞");
                    flag = false;
                }else{
                    node.setLike(node.getLike()-1);
                    bottom_like.setBackgroundColor(Color.WHITE);
                    bottom_like.setText(node.getLike()+"");
                    fragment.like.setText(node.getLike()+"人点赞");
                    flag = true;
                }
                break;
            case R.id.input :
                viewPager.setVisibility(View.GONE);
                viewPagerFlag = true;
                input.setCursorVisible(true);
                bottom_like.setVisibility(View.GONE);
                bottom_share.setVisibility(View.GONE);
                face.setVisibility(View.VISIBLE);
                finish.setVisibility(View.VISIBLE);
                break;
            case R.id.allInformation :
                input.setCursorVisible(false);
                imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(),0);
                bottom_like.setVisibility(View.VISIBLE);
                bottom_share.setVisibility(View.VISIBLE);
                face.setVisibility(View.GONE);
                finish.setVisibility(View.GONE);
                break;
            case R.id.bottom_share :
                Toast.makeText(this, "打开转发页面", Toast.LENGTH_SHORT).show();
                break;
            case R.id.finish :
                CommentInfo commentInfo = new CommentInfo();
                commentInfo.setImageURL(node.getImageURL());
                commentInfo.setName(node.getName());
                commentInfo.setDate("2018-10-10");
                commentInfo.setComtent(input.getText().toString());
                list.add(commentInfo);
                fragment.adapter.setData(list);
                fragment.adapter.notifyDataSetChanged();
                input.setText("");
                input.setCursorVisible(false);
                imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(),0);
                break;
            case R.id.face :
                Toast.makeText(this, "打开表情页面", Toast.LENGTH_SHORT).show();
                break;
            case R.id.function :
                if(viewPagerFlag){
                    imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(),0);
                    viewPager.setVisibility(View.VISIBLE);
                    viewPagerFlag = false;
                }else{
                    viewPager.setVisibility(View.GONE);
                    viewPagerFlag = true;
                }
                break;
        }
    }
}
