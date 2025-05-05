package thread;

import java.util.Optional;
import java.util.List;

class Order {
    private Optional<Double> discount;

    public Order(Double discount) {
        this.discount = Optional.ofNullable(discount);
    }

    public Optional<Double> getDiscount() {
        return this.discount;
    }
}

class User {
    private List<Order> orders;

    public User(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return this.orders;
    }
}

public class DiscountProcessor1 {

    public static void main(String[] args) {
        List<User> users = List.of(
                new User(List.of(new Order(10.00), new Order(20.00))),
                new User(List.of(new Order(30.00), new Order(40.00))),
                new User(List.of(new Order(null), new Order(null)))
        );

        double averageDiscount = users.stream().flatMap(user -> user.getOrders().stream())
                .flatMap(dis -> dis.getDiscount().stream())
                .mapToDouble(Double::doubleValue).average().orElse(0.0);

        System.out.println("Average discount:" + averageDiscount);
    }
}
