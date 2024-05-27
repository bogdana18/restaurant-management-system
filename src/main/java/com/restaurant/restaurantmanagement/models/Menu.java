package com.restaurant.restaurantmanagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuItemId;
    private String name;
    private String description;
    private float price;
    private String category;

    @OneToMany(mappedBy = "menuItem")
    private List<OrderDetail> orderDetails;
}

