package ci553.happyshop.catalogue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductValidationTest {

    @Test
    void rejectNegativeOrderedQuantity() {
        Product product = new Product("0001", "T-shirt", "0001.jpg", 20.00, 10);

        assertThrows(IllegalArgumentException.class, () -> {
            product.setOrderedQuantity(-5);
        });
    }

    @Test
    void rejectZeroOrderedQuantity() {
        Product product = new Product("0001", "T-shirt", "0001.jpg", 20.00, 10);

        assertThrows(IllegalArgumentException.class, () -> {
            product.setOrderedQuantity(0);
        });
    }

    @Test
    void acceptValidOrderedQuantity() {
        Product product = new Product("0001", "T-shirt", "0001.jpg", 20.00, 10);

        product.setOrderedQuantity(3);

        assertEquals(3, product.getOrderedQuantity());
    }

    @Test
    void rejectNegativeStockQuantity() {
        Product product = new Product("0001", "T-shirt", "0001.jpg", 20.00, 10);

        assertThrows(IllegalArgumentException.class, () -> {
            product.setStockQuantity(-10);
        });
    }

    @Test
    void acceptZeroStockQuantity() {
        Product product = new Product("0001", "T-shirt", "0001.jpg", 20.00, 10);

        product.setStockQuantity(0);

        assertEquals(0, product.getStockQuantity());
    }

    @Test
    void acceptValidStockQuantity() {
        Product product = new Product("0001", "T-shirt", "0001.jpg", 20.00, 10);

        product.setStockQuantity(20);

        assertEquals(20, product.getStockQuantity());
    }
}
