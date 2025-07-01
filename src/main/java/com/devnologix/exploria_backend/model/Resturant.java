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
 */
@Entity
@Table(name = "resturant_sirsa")
public class Resturant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name="description", nullable=false)
    private String description;
    @Column(name = "rating", nullable = false)
    private Double rating;
    @ElementCollection
    @CollectionTable(name = "image_urls_ncu", joinColumns = @JoinColumn(name = "image_id"))
    private List<String> image_urls;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resturant_id")
    private List<Dish> dishes;
    public List<Dish> getDishes() {
        return dishes;
    }
    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
    public Resturant() {
    }
    public Resturant(long id, String name, String description, Double rating, List<String> image_urls,
            List<Dish> dishes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.image_urls = image_urls;
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
}
