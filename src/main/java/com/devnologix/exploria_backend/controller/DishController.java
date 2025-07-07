package com.devnologix.exploria_backend.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devnologix.exploria_backend.model.Dish;
import com.devnologix.exploria_backend.service.DishService;


// Offerring
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Dish")
public class DishController {
    private DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public ResponseEntity<Dish> saveExpense(@RequestBody Dish dish){
        return new ResponseEntity<Dish>(dishService.save(dish), HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Dish>> get(){
        return new ResponseEntity<List<Dish>>(dishService.getAllDishes(), HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Dish> getExpenseById(@PathVariable("id") Long id){
        // System.out.println("The Id we are getting is "+id);
        return new ResponseEntity<Dish>(dishService.getDishById(id), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Boolean> deleteExpenseById(@PathVariable("id") Long id){
        // System.out.println("The Id we are getting is "+id);
        return new ResponseEntity<Boolean>(dishService.deleteDishById(id), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateById/{id}")
    public ResponseEntity<Dish> updateExpenseById(@PathVariable("id") Long id, @RequestBody Dish Dish){
        return new ResponseEntity<Dish>(dishService.updateDishById(id, Dish), HttpStatus.OK);
    }

    @GetMapping("/getAllDishByCategory/{category}")
    public ResponseEntity<List<Dish>> getAllDishByCategory(@PathVariable("category") String category){
        return new ResponseEntity<List<Dish>>(dishService.getAllDishByCategory(category), HttpStatus.OK);
    }
    @GetMapping("/getAllDishByPrice/{min}/{max}")
    public ResponseEntity<List<Dish>> getAllDishByPrice(@PathVariable("min") double min, @PathVariable("max") double max){
        return new ResponseEntity<List<Dish>>(dishService.getAllDishByPrice(min, max), HttpStatus.OK);
    }
    @GetMapping("/getAllDishByRating/{min}/{max}")
    public ResponseEntity<List<Dish>> getAllDishByRating(@PathVariable("min") double min, @PathVariable("max") double max){
        return new ResponseEntity<List<Dish>>(dishService.getAllDishByRating(min, max), HttpStatus.OK);
    }
    @GetMapping("/getAllDishByResturantId/{resturantId}")
    public ResponseEntity<List<Dish>> getAllDishByCategory(@PathVariable("resturantId") Long id){
        System.out.println("Controller Called");
        return new ResponseEntity<List<Dish>>(dishService.getAllDishByResturantId(id), HttpStatus.OK);
    } 
    @GetMapping("/getAllDishBySearch/{search}")
    public ResponseEntity<List<Dish>> getAllDishBySearch(@PathVariable("search") String search){
        System.out.println(search+" is Samosa");
        return new ResponseEntity<List<Dish>>(dishService.getAllDishBySearch(search), HttpStatus.OK);
    }

}
