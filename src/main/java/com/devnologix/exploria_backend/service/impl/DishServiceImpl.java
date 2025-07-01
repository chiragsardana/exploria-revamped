package com.devnologix.exploria_backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devnologix.exploria_backend.service.DishService;
import com.devnologix.exploria_backend.exception.ResourceNotFoundException;
import com.devnologix.exploria_backend.model.Dish;
import com.devnologix.exploria_backend.repository.DishRepository;


@Service
public class DishServiceImpl  implements DishService{
    private DishRepository dishRepository;
    
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Dish save(Dish dish) {
        // TODO Auto-generated method stub
        return dishRepository.save(dish);
    }

    @Override
    public List<Dish> getAllDishes() {
        // TODO Auto-generated method stub
        return dishRepository.findAll();
    }

    @Override
    public Dish getDishById(long id) {
        // TODO Auto-generated method stub
        return dishRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Dish", "Id", dishRepository));
    }

    @Override
    public Dish updateDishById(long id, Dish dish) {
        // TODO Auto-generated method stub
        dish.setId(id);
        return dishRepository.save(dish);
    }

    @Override
    public boolean deleteDishById(long id) {
        // TODO Auto-generated method stub
        Dish dish = getDishById(id);
        dishRepository.delete(dish);
        if(dishRepository.existsById(id)){
            return false;
        }
        return true;
    }

    @Override
    public List<Dish> getAllDishByCategory(String category) {
        // TODO Auto-generated method stub
        return dishRepository.findAllDishByCategory(category);
    }
    @Override
    public List<Dish> getAllDishByResturantId(Long id) {
        // TODO Auto-generated method stub
        return dishRepository.findAllDishByResturantId(id);
    }

    @Override
    public List<Dish> getAllDishByPrice(double min, double max) {
        // TODO Auto-generated method stub
        return dishRepository.findAllDishByPrice(min, max);
    }

    @Override
    public List<Dish> getAllDishByRating(double min, double max) {
        // TODO Auto-generated method stub
        return dishRepository.findAllDishByRating(min, max);
    }

    @Override
    public List<Dish> getAllDishBySearch(String search) {
        // TODO Auto-generated method stub
        return dishRepository.findAllDishBySearch(search);
    }
    
}
