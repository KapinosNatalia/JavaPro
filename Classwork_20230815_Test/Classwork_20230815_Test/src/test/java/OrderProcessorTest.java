import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderProcessorTest {
    @Mock
    Person person;

    OrderProcessor orderProcessor = new OrderProcessor();

    @BeforeEach
    void setUp() {
        List<Product> products1 = List.of(new Product("Product1", 10.0, 20, "Category1"), new Product("Product2", 20.0, 30, "Category2"));
        Order order1 = new Order(1, person, products1, LocalDate.now().minusDays(5));
        List<Product> products2 = List.of(new Product("Product3", 5.0, 3, "Category2"), new Product("Product4", 15.0, 2, "Category3"));
        Order order2 = new Order(2, person, products2, LocalDate.now().plusDays(5));
        List<Product> products3 = List.of(new Product("Product5", 10.0, 20, "Category1"), new Product("Product6", 20.0, 30, "Category2"));
        Order order3 = new Order(3, person, products3, LocalDate.now().minusDays(5));
        orderProcessor.addOrder(order1);
        orderProcessor.addOrder(order2);
        orderProcessor.addOrder(order3);
    }

    @Test
    void addOrderTest() {
        List<Product> products4 = List.of(new Product("Product5", 10.0, 20, "Category1"), new Product("Product6", 20.0, 30, "Category2"));
        Order order4 = new Order(4, person, products4, LocalDate.now().minusDays(5));
        orderProcessor.addOrder(order4);
        Assertions.assertEquals(4, orderProcessor.getOrders().size());
    }

    @Test
    void addNullOrderExceptionTest() {
        OrderProcessor orderProcessor = new OrderProcessor();
        Assertions.assertThrows(OrderDoesNotExistException.class, () -> orderProcessor.addOrder(null));
    }
    @Test
    void addAlreadyAddedOrderExceptionTest() {
        List<Product> products3 = List.of(new Product("Product5", 10.0, 20, "Category1"), new Product("Product6", 20.0, 30, "Category2"));
        Order order3 = new Order(3, person, products3, LocalDate.now().minusDays(5));
        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.addOrder(order3);
        Assertions.assertThrows(OrderAlreadyExistException.class, () -> orderProcessor.addOrder(order3));
    }
    @Test
    void calculateTotalRevenueTest() {
        Assertions.assertEquals(1645, orderProcessor.calculateTotalRevenue());
    }

    @Test
    void getExpiredOrdersTest() {
        Assertions.assertEquals(2, orderProcessor.getExpiredOrders().size());
    }
}