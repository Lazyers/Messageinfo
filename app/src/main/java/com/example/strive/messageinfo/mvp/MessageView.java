package com.example.strive.messageinfo.mvp;

import com.example.strive.messageinfo.entity.Node;

import java.util.List;

public interface MessageView {
    void showData(List<Node> nodeList);

    void showFailureMessage(String msg);

}
