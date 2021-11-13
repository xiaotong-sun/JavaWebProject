package com.example.book.domain;

public class ShoppingTrolley {
    private int sid;
    private int uid;
    private int bid;
    private int number;
    private double price;

    private String title;

    @Override
    public String toString() {
        return "ShoppingTrolley{" +
                "sid=" + sid +
                ", uid=" + uid +
                ", bid=" + bid +
                ", number=" + number +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
