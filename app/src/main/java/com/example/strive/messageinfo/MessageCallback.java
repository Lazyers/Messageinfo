package com.example.strive.messageinfo;

import java.util.List;

public interface MessageCallback {
    void onSuccess(List<Node> nodeList);

    void onError(String msg);

    void onComplete();
}
