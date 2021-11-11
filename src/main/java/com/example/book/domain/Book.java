package com.example.book.domain;

public class Book {
    private int bid;
    private String title;
    private double price;
    private String publisher;
    private int inventory;
    private String picture;
    private String introduction;

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", publisher='" + publisher + '\'' +
                ", inventory=" + inventory +
                ", picture='" + picture + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
