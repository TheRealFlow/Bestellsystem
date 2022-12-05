package de.neuefische.service;

import de.neuefische.model.Order;
import de.neuefische.model.Product;
import de.neuefische.repo.OrderRepo;
import de.neuefische.repo.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ShopService {
    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public Order orderProducts(List<String> productIds) {
        List<Product> productsToOrder = new ArrayList<>();
        for (String productId : productIds) {
            Product productToAdd = getProduct(productId);
            productsToOrder.add(productToAdd);
        }
        String id = UUID.randomUUID().toString();
        return orderRepo.addOrder(new Order(id, productsToOrder));
    }

    private Product getProduct(String productId) {
        Optional<Product> optionalProduct = productRepo.getProduct(productId);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            throw new IllegalArgumentException("A Product with the ID " + productId + " is not existing");
        }
    }
}
