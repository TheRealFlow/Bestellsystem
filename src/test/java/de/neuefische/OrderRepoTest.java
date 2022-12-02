package de.neuefische;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


class OrderRepoTest {
    @Test
    void addOrder_ShouldAddTheOrderToTheMap() {
        OrderRepo orderRepo = new OrderRepo();

        orderRepo.addOrder(new Order("order1", List.of(
                new Product("1", "Brot"),
                new Product("2", "Milch")
        )));

        assertTrue(orderRepo.listOrders().contains(new Order("order1", List.of(
                new Product("1", "Brot"),
                new Product("2", "Milch")
        ))));
    }

    @Test
    void listOrder_ShouldReturnAllOrders() {
        OrderRepo orderRepo = new OrderRepo();
        orderRepo.addOrder(new Order("order1", List.of(
                new Product("1", "Brot"),
                new Product("2", "Milch")
        )));
        orderRepo.addOrder(new Order("order2", List.of(
                new Product("1", "Brot"),
                new Product("3", "Butter")
        )));

        List<Order> actual = orderRepo.listOrders();

        assertThat(actual).containsExactlyInAnyOrder (
                new Order("order1", List.of(
                        new Product("1", "Brot"),
                        new Product("2", "Milch")
                )),
                new Order("order2", List.of(
                        new Product("1", "Brot"),
                        new Product("3", "Butter")
                ))
        );
        assertEquals(2, actual.size());
    }
}