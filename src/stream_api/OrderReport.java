package stream_api;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class OrderReport {

    record Product(String name, String category, int quantity, boolean inStock) {

    }

    record Order(List<Product> products, int totalValue, LocalDateTime time) {

    }

    public static void main(String[] args) {
        Iterable<Order> orders = List.of(
                new Order(List.of(new Product("iPhone", "Electronics", 2, true), new Product("USB Cable", "Electronics", 5, true), new Product("HeadPhones", "Electronics", 1, false)), 1500, LocalDateTime.now().minusHours(3L)),
                new Order(List.of(new Product("T-shirt", "Clothing", 3, true), new Product("Jeans", "Clothing", 2, true)), 600, LocalDateTime.now().minusHours(6L)),
                new Order(List.of(new Product("Sandals", "Footwear", 1, true), new Product("Shoes", "Footwear", 2, true)), 700, LocalDateTime.now().minusHours(6L)),
                new Order(List.of(new Product("iPhone", "Electronics", 7, true), new Product("Shoes", "Footwear", 7, true)), 1500, LocalDateTime.now().minusHours(3L))

                );

        Map<String, Integer> categoryCount = StreamSupport.stream(orders.spliterator(), true)
                .filter(o -> o.time.isAfter(LocalDateTime.now().minusDays(1)))
                .filter(o -> o.totalValue > 500)
                .flatMap(o -> o.products().stream())
                .filter(p -> p.inStock)
                .collect(Collectors.groupingBy(Product::category, LinkedHashMap::new, Collectors.summingInt(Product::quantity)))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(categoryCount);
    }
}

