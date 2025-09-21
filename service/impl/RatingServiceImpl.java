package com.devnologix.exploria_backend.service.impl;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.devnologix.exploria_backend.service.RatingService;

import com.devnologix.exploria_backend.exception.ResourceNotFoundException;
import com.devnologix.exploria_backend.model.Rating;
import com.devnologix.exploria_backend.repository.RatingRepository;



@Service
public class RatingServiceImpl implements RatingService{
    private RatingRepository ratingRepository;
    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating save(Rating rating) {
        // TODO Auto-generated method stub
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        // TODO Auto-generated method stub
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRatingById(long id) {
        // TODO Auto-generated method stub
        return ratingRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Rating", "Id", ratingRepository));
    }

    @Override
    public Rating updateRatingById(long id, Rating rating) {
        // TODO Auto-generated method stub
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // ;
        System.out.println(authentication.getName() +" and "+ rating.getUser_id());
        if(!authentication.getName().equals(rating.getUser_id())){
            System.out.println("Entering the Update Block");
            rating.setUser_id("Not Matched!");
            return rating;
        }
        rating.setId(id);
        return ratingRepository.save(rating);
    }

    @Override
    public boolean deleteRatingById(long id) {
        // TODO Auto-generated method stub
        Rating rating = getRatingById(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // ;
        System.out.println(authentication.getName() +" and " + rating.getUser_id());
        if(!authentication.getName().equals(rating.getUser_id())){
            System.out.println("Entering the Block ");
            return false;
        }
        ratingRepository.delete(rating);
        if(ratingRepository.existsById(id)){
            return false;
        }
        return true;
    }

    @Override
    public List<Rating> getAllRatingByDishId(long dish_id) {
        // TODO Auto-generated method stub
        return ratingRepository.findAllRatingByDishId(dish_id);
    }

    @Override
    public List<Rating> getAllRatingByResturantId(long resturant_id) {
        // TODO Auto-generated method stub
        return ratingRepository.findAllRatingByResturantId(resturant_id);
    }

    @Override
    public List<Rating> getAllRatingByUserId(String user_id) {
        // TODO Auto-generated method stub
        return ratingRepository.findAllRatingByUserId(user_id);
    }
    
}
