package com.example.strive.messageinfo;

import java.util.List;

public class MessagePresenter {

    private MessageView messageView;

    public void attachView(MessageView messageView){
        this.messageView = messageView;
    }
    public void detachView(){
        this.messageView = null;
    }
    public boolean isAttachView(){
        return messageView != null;
    }

    public void getData(){
        MessageModel.getNetworkData(new MessageCallback() {
            @Override
            public void onSuccess(List<Node> nodeList) {
                //显示数据
                if(isAttachView()){
                    messageView.showData(nodeList);
                }
            }

            @Override
            public void onError(String msg) {
                //提示失败信息
                if(isAttachView()){
                    messageView.showFailureMessage(msg);
                }
            }

            @Override
            public void onComplete() {
                //隐藏进度条
            }
        });
    }
}
