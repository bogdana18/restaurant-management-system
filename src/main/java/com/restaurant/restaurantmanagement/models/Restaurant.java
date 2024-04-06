package com.restaurant.restaurantmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor

public class Restaurant {
    private Long id;
    private String name;
    private String title;
    private String phone;
    private String classroom;
}
