package com.devnologix.exploria_backend.model;

import java.util.List;

import jakarta.persistence.*;

/*
 * Dish Entity
 * Dish Id
 * Name
 * Price
 * Category
 * Resturant Id
 * Rating(Below Class)
 * Descrpition
 */

@Entity
@Table(name = "dish_sirsa")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="name", nullable=false)
	private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "category", nullable = false)
    private String category;
    @Column(name = "resturant_id", nullable = false)
    private long resturant_id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dish_id")
    private List<Rating> ratings;
    @Column(name = "rating")
    private double rating;
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public Dish() {
    }
    public Dish(long id, String name, String description, Double price, String category, long resturant_id,
            List<Rating> ratings, int rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.resturant_id = resturant_id;
        this.ratings = ratings;
        this.rating = rating;
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
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public long getResturant_id() {
        return resturant_id;
    }
    public void setResturant_id(long resturant_id) {
        this.resturant_id = resturant_id;
    }
    public List<Rating> getRatings() {
        return ratings;
    }
    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

}
