package productApp.repository;
import productApp.entities.Product;
import productApp.strategy.InMemoryStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ProductRepositoryInMemoryTest {
    ProductRepository productRepository;

    Product product;

    Product productInMemory;

    @BeforeEach
    public void setUp() {
        productRepository = ProductRepository.getInstance();
        productRepository.init(new InMemoryStrategy<Product>());
        product = new Product();
        product.setName("Lactel");
        product.setExpirationDate("11/03/22");
        product.setPrice(0.99F);
        productInMemory = productRepository.add(product);
    }

    @Test
    public void can_add_product() throws Exception {
        assertNotNull(productInMemory.getId());
        assertEquals("Lactel", productInMemory.getName());
        assertEquals("11/03/22", productInMemory.getExpirationDate());
        assertEquals(0.99F, productInMemory.getPrice());
    }

    @Test
    public void can_get_product() throws Exception {
        Product expectedProduct = productRepository.get(productInMemory.getId());
        assertEquals(productInMemory.getId(), expectedProduct.getId());
    }

    @Test
    public void can_update_product() throws Exception {
        product.setName("Jus Orange");
        Product update = productRepository.update(product);
        assertEquals(update.getId(), product.getId());
    }

    @Test
    public void can_remove_product() throws Exception {
        boolean isRemoved = productRepository.remove(productInMemory.getId());
        assertTrue(isRemoved);
    }
}