package com.restaurant.restaurantmanagement.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplyId;
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;
    private int quantity;
    private Date dateSupplied;
    private String supplierName;
}
