package com.ltp.globalsuperstore;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Item {

    private String id;
    private String category;
    private String name;
    private Double price;
    private Double discount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Item(String category, String name, Double price, Double discount, Date date) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.date = date;
    }

    public Item() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFormatDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        return formatter.format(this.date);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", date=" + date +
                '}';
    }
}
