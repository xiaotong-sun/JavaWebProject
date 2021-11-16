package com.example.book.domain;

public class BookNumber {
    private int maxBid;
    private int number;

    @Override
    public String toString() {
        return "BookNumber{" +
                "maxBid=" + maxBid +
                ", number=" + number +
                '}';
    }

    public int getMaxBid() {
        return maxBid;
    }

    public void setMaxBid(int maxBid) {
        this.maxBid = maxBid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
