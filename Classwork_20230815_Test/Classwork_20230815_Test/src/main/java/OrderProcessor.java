import java.util.ArrayList;
import java.util.List;

//        OrderProcessor:
//        Поля:
//        List<Order> orders
//        Методы:
//
//        Конструктор без параметров.
//        void addOrder(Order order) - добавляет заказ в список заказов.
//        double calculateTotalRevenue() - вычисляет общую выручку от всех заказов.
//        List<Order> getExpiredOrders() - возвращает список заказов, у которых истекла дата.
public class OrderProcessor {
    private List<Order> orders = new ArrayList<>();

    public OrderProcessor() {
    }

    //- добавляет заказ в список заказов.
    public void addOrder(Order order) {
        if (order == null) {
            throw new OrderDoesNotExistException("Order is NULL");
        }
        if (orders.contains(order)) {
            throw new OrderAlreadyExistException("Order already added to list");
        }
        orders.add(order);
    }

    // - вычисляет общую выручку от всех заказов.
    public double calculateTotalRevenue() {
        return orders.stream()
                .mapToDouble(Order::calculateTotalPrice)
                .sum();
    }

    //- возвращает список заказов, у которых истекла дата.
    public List<Order> getExpiredOrders() {
        return orders.stream()
                .filter(Order::isOrderExpired)
                .toList();
    }

    public List<Order> getOrders() {
        return orders;
    }
}
