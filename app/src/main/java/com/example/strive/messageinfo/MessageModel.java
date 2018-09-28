package com.example.strive.messageinfo;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

public class MessageModel {
    private static int num = 0;
    private final static int size = 5;
    public static void getNetworkData(final MessageCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showData(callback);
            }
        },2000);
    }
    private static void showData(final MessageCallback callback){
        List<Node> list = new ArrayList<>();
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
            status.setPersonCreatNum(14*i);
            status.setPersonCollectNum(167*i);
            node.setStatus(status);
            list.add(node);
        }
        for (int i = 0; i <= size; i++) {
            if(i == 2){
                Node node = new Node();
                List<Recomment> list1 = new ArrayList<>();
                for(int j = 0; j < 10; j++){
                    Recomment recomment = new Recomment();
                    recomment.setHeadImage(R.drawable.plxl);
                    recomment.setName("名人"+j);
                    recomment.setIntroduce("个人简介"+j);
                    list1.add(recomment);
                 }
                 node.setRecommentList(list1);
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
                status.setPersonCreatNum(4*i);
                status.setPersonCollectNum(67*i);
                node.setStatus(status);
                list.add(node);
            }
        }
        num++;
        callback.onSuccess(list);
    }
}
