package com.example.book.domain;

public class Purchase {
    private int pid;
    private int uid;
    private int bid;
    private int number;
    private double price;
    private String time;
    private String title;

    @Override
    public String toString() {
        return "Purchase{" +
                "pid=" + pid +
                ", uid=" + uid +
                ", bid=" + bid +
                ", number=" + number +
                ", price=" + price +
                ", time='" + time + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
