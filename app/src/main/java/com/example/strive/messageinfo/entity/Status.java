package com.example.strive.messageinfo.entity;

import java.io.Serializable;

public class Status implements Serializable{
    private int userNum = 0;
    private int noteNum;
    private int followNum;
    private int collectNum;
    private String readTime;
    private int personCollectNum;
    private int personCreateNum;

    public int getPersonCreateNum() {
        return personCreateNum;
    }

    public void setPersonCreateNum(int personCreateNum) {
        this.personCreateNum = personCreateNum;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public int getNoteNum() {
        return noteNum;
    }

    public void setNoteNum(int noteNum) {
        this.noteNum = noteNum;
    }

    public int getFollowNum() {
        return followNum;
    }

    public void setFollowNum(int followNum) {
        this.followNum = followNum;
    }

    public int getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(int collectNum) {
        this.collectNum = collectNum;
    }

    public String getReadTime() {
        return readTime;
    }

    public void setReadTime(String readTime) {
        this.readTime = readTime;
    }

    public int getPersonCollectNum() {
        return personCollectNum;
    }

    public void setPersonCollectNum(int personCollectNum) {
        this.personCollectNum = personCollectNum;
    }
}
