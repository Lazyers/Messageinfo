package com.example.strive.messageinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserWindow extends AppCompatActivity implements View.OnClickListener {
    private TextView statName,userNum,nodeNum,followNum,collectNum,readNum,creat,personCollect;
    private Button button;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = this.findViewById(R.id.title);
        view.setVisibility(View.GONE);
        setContentView(R.layout.activity_user_window);

//        setFinishOnTouchOutside(false);
//        WindowManager m = getWindowManager();
//        Display d = m.getDefaultDisplay();  //为获取屏幕宽、高
//        WindowManager.LayoutParams p = getWindow().getAttributes();  //获取对话框当前的参数值
//        p.height = (int) (d.getHeight() * 0.6);   //高度设置为屏幕的0.6
//        p.width = (int) (d.getWidth() * 0.7);    //宽度设置为屏幕的0.7
//        p.alpha = 1.0f;      //设置本身透明度
//        p.dimAmount = 0.5f;      //设置窗口外黑暗度
//        getWindow().setAttributes(p);

        statName = findViewById(R.id.stat_name);
        userNum = findViewById(R.id.userNum);
        nodeNum = findViewById(R.id.nodeNum);
        followNum = findViewById(R.id.followNum);
        collectNum = findViewById(R.id.collectNum);
        readNum = findViewById(R.id.readNum);
        creat = findViewById(R.id.creat);
        personCollect = findViewById(R.id.personcollect);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Status status = (Status) bundle.getSerializable("status");
        name = intent.getStringExtra("name");

        statName.setText(name);
        userNum.setText("使用量 ："+status.getUserNum());
        nodeNum.setText("笔记 ："+status.getNoteNum());
        followNum.setText("关注 ："+status.getFollowNum());
        collectNum.setText("收藏 ："+status.getCollectNum());
        readNum.setText("阅读 ："+status.getReadTime());
        creat.setText(status.getPersonCreatNum()+"个创作专题");
        personCollect.setText("收藏量 ："+status.getPersonCollectNum());

        userNum.setOnClickListener(this);
        nodeNum.setOnClickListener(this);
        followNum.setOnClickListener(this);
        collectNum.setOnClickListener(this);
        readNum.setOnClickListener(this);
        creat.setOnClickListener(this);
        personCollect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.userNum :
                Toast.makeText(this, "打开"+name+"的使用记录页面",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.nodeNum :
                Toast.makeText(this, "打开"+name+"的全部笔记页面",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.followNum :
                Toast.makeText(this, "打开"+name+"的所有关注页面",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.collectNum :
                Toast.makeText(this, "打开"+name+"的全部收藏页面",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.readNum :
                Toast.makeText(this, "打开"+name+"的阅读时间页面", Toast.LENGTH_SHORT).show();
                break;
            case R.id.creat :
                Toast.makeText(this, "打开"+name+"创建的专题页面", Toast.LENGTH_SHORT).show();
                break;
            case R.id.personcollect :
                Toast.makeText(this, "打开"+name+"创建的专题页面", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
