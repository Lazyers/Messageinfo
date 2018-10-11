package com.example.strive.messageinfo.entity;

import java.io.Serializable;
import java.util.List;
public class Node implements Serializable {
    private int imageURL;
    private String name;
    private String data;
    private int stat;
    private String type;
    private int comment;
    private List<CommentInfo> commentInfoList;
    private int like;
    private String content;
    private List<Recommend> recommendList;//
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Recommend> getRecommendList() {

        return recommendList;
    }

    public void setRecommendList(List<Recommend> recommendList) {
        this.recommendList = recommendList;
    }

    public List<CommentInfo> getCommentInfoList() {
        return commentInfoList;
    }

    public void setCommentInfoList(List<CommentInfo> commentInfoList) {
        this.commentInfoList = commentInfoList;
    }

    public int getImageURL() {
        return imageURL;
    }

    public void setImageURL(int imageURL) {
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getStat() {
        return stat;
    }

    public void setStat(int stat) {
        this.stat = stat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
