package com.devnologix.exploria_backend.model;

import java.util.List;

import jakarta.persistence.*;

/*
 * Resturant Entity 
 * Resturant id
 * Name
 * Description
 * Rating(Double)
 * Image
 * Dishes->Array of Dish(Class Below)
 * N
 * 
 * Need to add few things for research project
 * 1. cost for one (in integer)
 * 2. delivery time(in minutes)
 * 3. cuisine array
 */
@Entity
@Table(name = "resturant_sirsa")
public class Resturant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "rating", nullable = false)
    private Double rating;

    @ElementCollection
    @CollectionTable(name = "image_urls_sirsa", joinColumns = @JoinColumn(name = "image_id"))
    private List<String> image_urls;

    // Store cuisines in a separate table (like imageUrls)
    @ElementCollection
    @CollectionTable(name = "restaurant_cuisines_sirsa", joinColumns = @JoinColumn(name = "resturant_id"))
    @Column(name = "cuisine")
    private List<String> cuisines;

    @Column(name = "cost_for_one", nullable = false)
    private Integer costForOne;

    @Column(name = "delivery_time", nullable = false)
    private Integer deliveryTime;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resturant_id")
    private List<Dish> dishes;

    public Resturant() {
    }

    // ✅ Constructor without ID (for creating new restaurants)
    public Resturant(long id, String name, String description, Double rating,
            Integer costForOne, Integer deliveryTime,
            List<String> image_urls, List<String> cuisines) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.costForOne = costForOne;
        this.deliveryTime = deliveryTime;

        this.cuisines = cuisines;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<String> getImage_urls() {
        return image_urls;
    }

    public void setImage_urls(List<String> image_urls) {
        this.image_urls = image_urls;
    }

    public Integer getCostForOne() {
        return costForOne;
    }

    public void setCostForOne(Integer costForOne) {
        this.costForOne = costForOne;
    }

    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public List<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }
}
