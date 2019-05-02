package com.example.sweater.domain;

import javax.persistence.*;

@Entity
public class Module implements Comparable<Module>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean image;
    private boolean text;
    private boolean code;

    private Integer orderNumber;
    private String shortText;
    private String filename;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "front_id")
    private Front front;

    public Module() {
    }

    public Module(boolean Image, boolean Text, boolean Code, String text, String filename, int orderNumber, Front front) {
        this.image = Image;
        this.text = Text;
        this.code = Code;
        this.shortText = text;
        this.filename = filename;
        this.orderNumber = orderNumber;
        this.front = front;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Front getFront() {
        return front;
    }

    public void setFront(Front front) {
        this.front = front;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isImage() {
        return image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }

    public boolean isText() {
        return text;
    }

    public void setText(boolean text) {
        this.text = text;
    }

    public boolean isCode() {
        return code;
    }

    public void setCode(boolean code) {
        this.code = code;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
    @Override
    public int compareTo(Module module) {
        return this.orderNumber.compareTo(module.orderNumber);
    }
}
