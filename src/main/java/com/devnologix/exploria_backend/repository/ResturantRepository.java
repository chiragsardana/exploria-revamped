package com.devnologix.exploria_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devnologix.exploria_backend.model.Resturant;




public interface ResturantRepository extends JpaRepository<Resturant, Long> {
    @Query(value = "SELECT r FROM Resturant r WHERE (r.rating >= :min AND r.rating <= :max)")
    public List<Resturant> findAllResturantByRating(@Param("min") double min, @Param("max") double max);

    @Query(value = "Select r FROM Resturant r Where r.description LIKE %:search%")
    public List<Resturant> findAllRestaurantBySearch(@Param("search") String search);


    // New Addition - 18th September 2025


    // Find restaurants within a cost range
    public List<Resturant> findByCostForOneBetween(Integer minCost, Integer maxCost);

    // // Cuisine is an @ElementCollection (List<String>)
    // @Query("SELECT r FROM Resturant r JOIN r.cuisines c WHERE c LIKE %:cuisine%")
    // List<Resturant> findByCuisinesContaining(@Param("cuisine") String cuisine);

    // List<Resturant> findByCuisines(String cuisine);
    @Query("SELECT r FROM Resturant r JOIN r.cuisines c WHERE LOWER(c) = LOWER(:cuisine)")
List<Resturant> findByCuisines(@Param("cuisine") String cuisine);



    // Example with Integer deliveryTime (in minutes)
    List<Resturant> findByDeliveryTimeBetween(Integer minTime, Integer maxTime);

    @Query("SELECT DISTINCT r.cuisines FROM Resturant r")
    List<String> findAllDistinctCuisines();

}
