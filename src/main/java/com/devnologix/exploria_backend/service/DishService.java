package com.devnologix.exploria_backend.service;

import java.util.List;


import com.devnologix.exploria_backend.model.Dish;



public interface DishService {
    public Dish save(Dish dish);
    public List<Dish> getAllDishes();
    public Dish getDishById(long id);
    public Dish updateDishById(long id, Dish dish);
    public boolean deleteDishById(long id);

    public List<Dish> getAllDishByCategory(String category);
    public List<Dish> getAllDishByResturantId(Long id);

    public List<Dish> getAllDishByPrice(double min, double max);
    public List<Dish> getAllDishByRating(double min, double max);

    public List<Dish> getAllDishBySearch(String search);
}
