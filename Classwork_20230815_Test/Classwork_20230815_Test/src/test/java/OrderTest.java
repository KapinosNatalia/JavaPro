import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderTest {
    @Mock
    Person person;

    //List<Product> products = new ArrayList<>();
    List<Product> products = List.of(new Product("Product1", 10.0, 20, "Category1"), new Product("Product2", 20.0, 30, "Category2"));
    Order order = new Order(1, person, products, LocalDate.now().minusDays(5));

    @Test
    void calculateTotalPriceTest() {
        Assertions.assertEquals(800, order.calculateTotalPrice());
    }

    @Test
    void getNumberOfProductsTest() {
        Assertions.assertEquals(50, order.getNumberOfProducts());
    }

    @Test
    void isOrderExpired() {
        Assertions.assertTrue(order.isOrderExpired());

        Order notExpiredOrder = new Order(1, person, products, LocalDate.now().plusDays(5));
        Assertions.assertFalse(notExpiredOrder.isOrderExpired());
    }
}