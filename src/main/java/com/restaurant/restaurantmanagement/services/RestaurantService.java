package com.restaurant.restaurantmanagement.services;

import com.restaurant.restaurantmanagement.models.Restaurant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class RestaurantService {
    private final List<Restaurant> restaurants = new ArrayList<>();
    private long ID = 0;

    public List<Restaurant> listDepartments() {
        return restaurants;
    }

    public void addDepartment(Restaurant restaurant) {
        restaurant.setId(++ID);
        restaurants.add(restaurant);
    }

    public void deleteDepartment(Long id) {
        restaurants.removeIf(department -> department.getId().equals(id));
    }

    public Restaurant getDepartmentById(Long id) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId().equals(id)) return restaurant;
        }
        return null;
    }

}
