package com.restaurant.restaurantmanagement.services;

import com.restaurant.restaurantmanagement.models.Inventory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class  InventoryService {
    private final List<Inventory> inventories = new ArrayList<>();

    public List<Inventory> listInventories() {
        return new ArrayList<>(inventories); // Повертаємо копію списку для уникнення змін
    }

    public void addInventory(Inventory inventory) {
        inventories.add(inventory);
    }

    public void deleteInventory(Long id) {
        inventories.removeIf(inventory -> inventory.getInventoryId().equals(id));
    }

    public Inventory getInventoryById(Long id) {
        return inventories.stream()
                .filter(inventory -> inventory.getInventoryId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
