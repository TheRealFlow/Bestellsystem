package de.neuefische;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products =  new ArrayList<>(List.of(
                new Product("1", "Brot"),
                new Product("2", "Milch"),
                new Product("3", "Butter")
        ));

        ProductRepo productRepo = new ProductRepo(products);

        productRepo.listProducts().add(new Product("4", "Käse"));
        System.out.println(productRepo.listProducts());
    }
}