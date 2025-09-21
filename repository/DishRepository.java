package com.devnologix.exploria_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devnologix.exploria_backend.model.Dish;





public interface DishRepository extends JpaRepository<Dish,Long> {


    @Query(value = "Select d FROM Dish d Where d.name LIKE %:search% OR d.description LIKE %:search% OR d.category LIKE %:search%")
    public List<Dish> findAllDishBySearch(@Param("search") String search);

    @Query(value = "SELECT d FROM Dish d WHERE d.category = :category")
    public List<Dish> findAllDishByCategory(@Param("category") String category);

    @Query(value = "SELECT d FROM Dish d WHERE d.resturant_id = :id")
    public List<Dish> findAllDishByResturantId(@Param("id") Long id);

    @Query(value = "SELECT d FROM Dish d WHERE (d.price >= :min AND d.price <= :max)")
    public List<Dish> findAllDishByPrice(@Param("min") double min, @Param("max") double max);

    @Query(value = "SELECT d FROM Dish d WHERE (d.rating >= :min AND d.rating <= :max)")
    public List<Dish> findAllDishByRating(@Param("min") double min, @Param("max") double max);
    
    
}
