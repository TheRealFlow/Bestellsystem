package de.neuefische.repo;

import de.neuefische.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
public class ProductRepo {
    private List<Product> products;

    public List<Product> listProducts() {
        return products;
    }

    public Optional<Product> getProduct(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                System.out.println(product);
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }
}
