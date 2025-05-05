package thread;

import java.util.List;
import java.util.Optional;

public class DiscountProcessor {

    static class Order {
        private final Optional<Double> discount;

        public Order(Double discount) {
            this.discount = Optional.ofNullable(discount);
        }

        public Optional<Double> getDiscount() {
            return this.discount;
        }
    }

    static class User {
        private final List<Order> orders;

        public User(List<Order> orders) {
            this.orders = orders;
        }

        public List<Order> getOrders() {
            return this.orders;
        }
    }

    public static void main(String[] args) {
        List<User> users = List.of(new User(List.of(new Order(10.0), new Order(5.0))),
                new User(List.of(new Order(15.0), new Order(20.0))),
                new User(List.of(new Order(null), new Order(null)))
                );

       double discountAverage= users.stream().flatMap(user->user.getOrders().stream())
                .flatMap(order->order.getDiscount().stream())
                .mapToDouble(Double::doubleValue)
                .average().orElse(0.0);

       System.out.println("Discount average:"+discountAverage);
    }
}
