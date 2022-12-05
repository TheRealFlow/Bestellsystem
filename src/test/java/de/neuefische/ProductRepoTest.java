package de.neuefische;

import de.neuefische.model.Product;
import de.neuefische.repo.ProductRepo;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class ProductRepoTest {
    @Test
    void getProduct_ShouldReturnAProductWithExistingID() {
        List<Product> products = List.of(
                new Product("1", "Brot"),
                new Product("2", "Milch"),
                new Product("3", "Butter")
        );
        ProductRepo productRepo = new ProductRepo(products);

        Optional<Product> actual = productRepo.getProduct("1");

        assertEquals(new Product("1", "Brot"), actual.get());
    }

    @Test
    void getProduct_ShouldDontReturnAProductWhenIDIsNotExisting() {
        List<Product> products = List.of(
                new Product("1", "Brot"),
                new Product("2", "Milch"),
                new Product("3", "Butter")
        );
        ProductRepo productRepo = new ProductRepo(products);

        Optional<Product> actual = productRepo.getProduct("4");

        assertTrue(actual.isEmpty());
    }

    @Test
    void listProducts_ShouldReturnAllProducts() {
        List<Product> products = List.of(
                new Product("1", "Brot"),
                new Product("2", "Milch"),
                new Product("3", "Butter")
        );
        ProductRepo productRepo = new ProductRepo(products);

        List<Product> actual = productRepo.listProducts();

        assertEquals(products, actual);
    }

}