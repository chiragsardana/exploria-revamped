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

import com.devnologix.exploria_backend.model.Resturant;
import com.devnologix.exploria_backend.service.ResturantService;





// Places
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Resturant")
public class ResturantController {
    private ResturantService resturantService;

    public ResturantController(ResturantService resturantService) {
        this.resturantService = resturantService;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public ResponseEntity<Resturant> saveExpense(@RequestBody Resturant resturant){
        return new ResponseEntity<Resturant>(resturantService.save(resturant), HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity<List<Resturant>> get(){
        return new ResponseEntity<List<Resturant>>(resturantService.getAllResturants(), HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Resturant> getExpenseById(@PathVariable("id") Long id){
        // System.out.println("The Id we are getting is "+id);
        return new ResponseEntity<Resturant>(resturantService.getResturantById(id), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Boolean> deleteExpenseById(@PathVariable("id") Long id){
        // System.out.println("The Id we are getting is "+id);
        return new ResponseEntity<Boolean>(resturantService.deleteResturantById(id), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateById/{id}")
    public ResponseEntity<Resturant> updateExpenseById(@PathVariable("id") Long id, @RequestBody Resturant Resturant){
        return new ResponseEntity<Resturant>(resturantService.updateResturantById(id, Resturant), HttpStatus.OK);
    }
    @GetMapping("/getResturantsByRating/{min}/{max}")
    public ResponseEntity<List<Resturant>> getResturantsByRating(@PathVariable("min") double min, @PathVariable("max") double max ){
        return new ResponseEntity<List<Resturant>>(resturantService.getResturantsByRating(min, max), HttpStatus.OK);
    }
    @GetMapping("/getRestaurantBySearch/{search}")
    public ResponseEntity<List<Resturant>> getResturantsBySearch(@PathVariable("search") String search) {
        return new ResponseEntity<List<Resturant>>(resturantService.getAllRestaurantBySearch(search), HttpStatus.OK);
    }
    
}
