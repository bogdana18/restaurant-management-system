package com.restaurant.restaurantmanagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private Date orderDate;
    private String status;
    private Float totalPrice;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
}