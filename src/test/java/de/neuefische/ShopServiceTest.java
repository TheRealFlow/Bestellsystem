package de.neuefische;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


class ShopServiceTest {
    @Test
    void orderExistingProductsShouldCreateANewOrder() {

        List<Product> products = List.of(
                new Product("1", "Brot"),
                new Product("2", "Milch"),
                new Product("3", "Butter")
        );
        ProductRepo productRepo = new ProductRepo(products);
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        Order actual = shopService.orderProducts(List.of("1", "2"));

        List<Product> expected = List.of(
                new Product("1", "Brot"),
                new Product("2", "Milch")
        );
        assertEquals(expected, actual.getProductList());
    }

    @Test
    void orderNonExistingProductsShouldThrowAException() {

        List<Product> products = List.of(
                new Product("1", "Brot"),
                new Product("2", "Milch"),
                new Product("3", "Butter")
        );
        ProductRepo productRepo = new ProductRepo(products);
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        try {
            shopService.orderProducts(List.of("3", "4"));
            fail();
        } catch (IllegalArgumentException actual) {
            assertEquals("A Product with the ID 4 is not existing", actual.getMessage());
        }
    }
}