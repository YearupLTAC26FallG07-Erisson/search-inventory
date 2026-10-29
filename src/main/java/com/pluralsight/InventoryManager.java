package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InventoryManager {
    private static final String FILE_NAME = "inventory.csv";

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 3) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());

                    products.add(new Product(id, name, price));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the inventory file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing price from file: " + e.getMessage());
        }

        return products;
    }
}
