package com.devnologix.exploria_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devnologix.exploria_backend.model.Rating;




public interface RatingRepository extends JpaRepository<Rating, Long>{

    @Query(value = "SELECT r FROM Rating r WHERE r.dish_id = :dish_id")
    public List<Rating> findAllRatingByDishId(@Param("dish_id") long dish_id);

    @Query(value = "SELECT r FROM Rating r WHERE r.resturant_id = :resturant_id")
    public List<Rating> findAllRatingByResturantId(@Param("resturant_id") long resturant_id);

    @Query(value = "SELECT r FROM Rating r WHERE r.user_id = :user_id")
    public List<Rating> findAllRatingByUserId(@Param("user_id") String user_id);
}
