package com.example.strive.messageinfo.mvp;

import android.os.Handler;

import com.example.strive.messageinfo.R;
import com.example.strive.messageinfo.entity.Recommend;
import com.example.strive.messageinfo.entity.Node;
import com.example.strive.messageinfo.entity.Status;

import java.util.ArrayList;
import java.util.List;

public class MessageModel {
    private static int num = 0;
    private static int load = 1;
    private final static int size = 5;
    public static void getNetworkData(final int flag, final MessageCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showData(flag,callback);
            }
        },1000);
    }
    private static void showData(int flag,final MessageCallback callback){
        List<Node> list = new ArrayList<>();

        if(flag == 1){
            for (int i = num; i > 0; i--) {
                Node node = new Node();
                node.setImageURL(R.drawable.plxl);
                node.setName("孙庆新" + (size+i));
                node.setData("2018-9-26");
                node.setType("共享笔记>");
                node.setContent("笔记的中心内容");
                node.setComment(1);
                node.setLike(1);
                Status status = new Status();
                status.setUserNum(3123*i);
                status.setNoteNum(5123*i);
                status.setFollowNum(3211*i);
                status.setCollectNum(12351*i);
                status.setReadTime("1123小时12分钟"+i);
                status.setPersonCreateNum(14*i);
                status.setPersonCollectNum(167*i);
                node.setStatus(status);
                list.add(node);
            }
            num++;
        }
        for (int i = 0; i <= size; i++) {
            if(i == 2){
                Node node = new Node();
                List<Recommend> list1 = new ArrayList<>();
                for(int j = 0; j < 5; j++){
                    Recommend recommend = new Recommend();
                    recommend.setHeadImage(R.drawable.plxl);
                    recommend.setName("名人"+j);
                    recommend.setIntroduce("个人简介"+j);
                    list1.add(recommend);
                 }
                 node.setRecommendList(list1);
                 list.add(node);
            }else{
                Node node = new Node();
                node.setImageURL(R.drawable.plxl);
                node.setName("孙庆新" + i);
                node.setData("2018-9-26");
                node.setType("共享笔记>");
                node.setContent("笔记的中心内容");
                node.setComment(1);
                node.setLike(1);
                Status status = new Status();
                status.setUserNum(40031*i);
                status.setNoteNum(500*i);
                status.setFollowNum(321*i);
                status.setCollectNum(1351*i);
                status.setReadTime("1123小时12分钟"+i);
                status.setPersonCreateNum(4*i);
                status.setPersonCollectNum(67*i);
                node.setStatus(status);
                list.add(node);
            }
        }
        if(flag == 2){
            for(int i = 0; i < load; i++){
                Node node = new Node();
                node.setImageURL(R.drawable.plxl);
                node.setName("孙庆新Load" + (i+1));
                node.setData("2018-9-26");
                node.setType("共享笔记>");
                node.setContent("笔记的中心内容");
                node.setComment(1);
                node.setLike(1);
                Status status = new Status();
                status.setUserNum(3123);
                status.setNoteNum(5123);
                status.setFollowNum(3211);
                status.setCollectNum(12351);
                status.setReadTime("1123小时12分钟");
                status.setPersonCreateNum(14);
                status.setPersonCollectNum(167);
                node.setStatus(status);
                list.add(node);
            }
            load++;
        }
        callback.onSuccess(list);
    }
}
