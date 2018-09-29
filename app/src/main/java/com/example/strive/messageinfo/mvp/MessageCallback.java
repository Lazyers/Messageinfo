package com.example.strive.messageinfo.mvp;

import com.example.strive.messageinfo.entity.Node;

import java.util.List;

public interface MessageCallback {
    void onSuccess(List<Node> nodeList);

    void onError(String msg);

    void onComplete();
}
