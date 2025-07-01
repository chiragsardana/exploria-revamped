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



}
