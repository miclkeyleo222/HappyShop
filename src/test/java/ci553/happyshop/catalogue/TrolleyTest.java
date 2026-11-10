
package ci553.happyshop.catalogue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrolleyTest {

    @Test
    void addOneProduct() {
        Trolley trolley = new Trolley();
        Product product = new Product("0001", "T-shirt", "0001.jpg", 20.00, 10);

        trolley.addProduct(product);

        assertEquals(1, trolley.getProducts().size());
    }

    @Test
    void mergeDuplicateProducts() {
        Trolley trolley = new Trolley();

        Product first = new Product("0001", "T-shirt", "0001.jpg", 20.00, 10);
        Product second = new Product("0001", "T-shirt", "0001.jpg", 20.00, 10);

        trolley.addProduct(first);
        trolley.addProduct(second);

        assertEquals(1, trolley.getProducts().size());
        assertEquals(2, trolley.getProducts().get(0).getOrderedQuantity());
    }

    @Test
    void sortProductsById() {
        Trolley trolley = new Trolley();

        Product second = new Product("0002", "Hoodie", "0002.jpg", 40.00, 10);
        Product first = new Product("0001", "T-shirt", "0001.jpg", 20.00, 10);

        trolley.addProduct(second);
        trolley.addProduct(first);

        assertEquals("0001", trolley.getProducts().get(0).getProductId());
        assertEquals("0002", trolley.getProducts().get(1).getProductId());
    }

    @Test
    void clearTrolley() {
        Trolley trolley = new Trolley();
        Product product = new Product("0001", "T-shirt", "0001.jpg", 20.00, 10);

        trolley.addProduct(product);
        trolley.clear();

        assertTrue(trolley.getProducts().isEmpty());
    }
}

