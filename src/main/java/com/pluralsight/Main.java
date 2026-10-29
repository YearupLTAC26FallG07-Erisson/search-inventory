package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Loading Store Inventory --- \n");

        // Load products from the inventory.csv file
        ArrayList<Product> inventory = InventoryManager.getInventory();

        // Sort the products by name using a Comparator on getName()
        Collections.sort(inventory, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().compareToIgnoreCase(p2.getName());
            }
        });

        // Display the sorted inventory
        System.out.println("Sorted Inventory List (By Name):");
        System.out.println("---------------------------------------------------------");
        for (Product product : inventory) {
            System.out.println(product);
        }
        System.out.println("---------------------------------------------------------");
    }
}
