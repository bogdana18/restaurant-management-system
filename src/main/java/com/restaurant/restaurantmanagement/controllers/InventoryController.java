package com.restaurant.restaurantmanagement.controllers;

import com.restaurant.restaurantmanagement.models.Inventory;
import com.restaurant.restaurantmanagement.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/inventories")
    public String listInventories(Model model) {
        List<Inventory> inventories = inventoryService.listInventories();
        model.addAttribute("inventories", inventories);
        return "inventories";
    }

    @PostMapping("/inventories/create")
    public String createInventory(Inventory inventory) {
        inventoryService.addInventory(inventory);
        return "redirect:/inventories";
    }

    @PostMapping("/inventories/delete/{id}")
    public String deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return "redirect:/inventories";
    }

    @GetMapping("/inventories/{id}")
    public String inventoryInfo(@PathVariable Long id, Model model) {
        Inventory inventory = inventoryService.getInventoryById(id);
        if (inventory != null) {
            model.addAttribute("inventory", inventory);
            return "inventory-info";
        }
        return "redirect:/inventories";
    }

    @GetMapping("/inventories/edit/{id}")
    public String editInventoryForm(@PathVariable Long id, Model model) {
        Inventory inventory = inventoryService.getInventoryById(id);
        if (inventory != null) {
            model.addAttribute("inventory", inventory);
            model.addAttribute("inventories", inventoryService.listInventories());
            return "inventories";
        }
        return "redirect:/inventories";
    }

    @PostMapping("/inventories/edit/{id}")
    public String editInventory(@PathVariable Long id, @ModelAttribute Inventory inventory) {
        Inventory existingInventory = inventoryService.getInventoryById(id);
        if (existingInventory != null) {
            existingInventory.setIngredient(inventory.getIngredient());
            existingInventory.setQuantity(inventory.getQuantity());
            existingInventory.setUnit(inventory.getUnit());
            // Save changes if you're using a database
        }
        return "redirect:/inventories";
    }
}
