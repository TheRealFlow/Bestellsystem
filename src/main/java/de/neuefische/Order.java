package de.neuefische;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private String id;
    private List<Product> productList;
}
