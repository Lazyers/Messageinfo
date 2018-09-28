package com.example.strive.messageinfo;

import java.util.List;

public interface MessageView {
    void showData(List<Node> nodeList);

    void showFailureMessage(String msg);

}
