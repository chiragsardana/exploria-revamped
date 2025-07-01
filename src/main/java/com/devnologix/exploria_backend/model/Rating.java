package com.devnologix.exploria_backend.model;

import jakarta.persistence.*;

/*
 * Rating Entity
 * Name 
 * user id
 * review
 * rating
 * dish id
 */
@Entity
@Table(name = "rating_sirsa")
public class Rating {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "user_id")
    private String user_id;
    @Column(name = "review", nullable = false)
    private String review;
    @Column(name = "stars", nullable = false)
    private Integer stars;
    @Column(name = "dish_id", nullable = false)
    private long dish_id;
    @Column(name = "resturant_id", nullable = false)
    private long resturant_id;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
    public Integer getStars() {
        return stars;
    }
    public void setStars(Integer stars) {
        this.stars = stars;
    }
    public long getDish_id() {
        return dish_id;
    }
    public void setDish_id(long dish_id) {
        this.dish_id = dish_id;
    }
    public long getResturant_id() {
        return resturant_id;
    }
    public void setResturant_id(long resturant_id) {
        this.resturant_id = resturant_id;
    }
    public Rating(long id, String user_id, String review, Integer stars, long dish_id, long resturant_id) {
        this.id = id;
        this.user_id = user_id;
        this.review = review;
        this.stars = stars;
        this.dish_id = dish_id;
        this.resturant_id = resturant_id;
    }
    public Rating() {
    }

}
