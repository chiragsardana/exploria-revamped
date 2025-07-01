package com.devnologix.exploria_backend.service;

import java.util.List;

import com.devnologix.exploria_backend.model.Resturant;



public interface ResturantService {
    public Resturant save(Resturant resturant);
    public List<Resturant> getAllResturants();
    public Resturant getResturantById(long id);
    public Resturant updateResturantById(long id, Resturant resturant);
    public boolean deleteResturantById(long id);
    public List<Resturant> getResturantsByRating(double min, double max);
    public List<Resturant> getAllRestaurantBySearch(String search);
}
