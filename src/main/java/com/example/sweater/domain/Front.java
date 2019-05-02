package com.example.sweater.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Front implements Comparable<Front>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String status;

    private Integer orderNumber;
    private String technology;
    private String heading;
    private String shortDescription;
    private String dateOfPosting;
    private String link;

    private String filename;

    public Front() {
    }

    public Front(String status, String heading, String shortDescription, String dateOfPosting, String filename, String technology, int orderNumber, String link) {
        this.status = status;
        this.heading = heading;
        this.shortDescription = shortDescription;
        this.dateOfPosting = dateOfPosting;
        this.filename = filename;
        this.technology = technology;
        this.orderNumber = orderNumber;
        this.link = link;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDateOfPosting() {
        return dateOfPosting;
    }

    public void setDateOfPosting(String dateOfPosting) {
        this.dateOfPosting = dateOfPosting;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public int compareTo(Front front) {
        return this.orderNumber.compareTo(front.orderNumber);
    }
}
