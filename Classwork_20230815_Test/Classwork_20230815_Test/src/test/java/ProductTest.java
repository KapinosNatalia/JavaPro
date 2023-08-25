import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private static final Product product = new Product("product1", 25.25, 4, "category1");

    @Test
    void getTotalPriceTest() {
        Assertions.assertEquals(101, product.getTotalPrice());
    }

    @Test
    void isAvailableTest() {
        Assertions.assertTrue(product.isAvailable());
    }

    @Test
    void isNotAvailableTest() {
        Product productNotAvailable = new Product("tomato", 10, 0, "vegetables");
        Assertions.assertFalse(productNotAvailable.isAvailable());
    }
}