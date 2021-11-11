package com.example.book.domain;

public class Purchase {
    private int pid;
    private int uid;
    private int bid;
    private String time;

    @Override
    public String toString() {
        return "Purchase{" +
                "pid=" + pid +
                ", uid=" + uid +
                ", bid=" + bid +
                ", time='" + time + '\'' +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
