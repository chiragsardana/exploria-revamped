package com.devnologix.exploria_backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Preference {

    @Id
    private String userId;   // user provides string id

    private String costForOne;
    private String deliveryTime;
    private String cuisine;

    // Constructors
    public Preference() {}

    public Preference(String userId, String costForOne, String deliveryTime, String cuisine) {
        this.userId = userId;
        this.costForOne = costForOne;
        this.deliveryTime = deliveryTime;
        this.cuisine = cuisine;
    }

    // Getters & Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCostForOne() {
        return costForOne;
    }

    public void setCostForOne(String costForOne) {
        this.costForOne = costForOne;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }
}
