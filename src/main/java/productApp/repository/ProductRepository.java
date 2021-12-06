package productApp.repository;

import productApp.entities.Product;

public class ProductRepository extends Repository<Product>{

    private static final ProductRepository INSTANCE = new ProductRepository();

    public static ProductRepository getInstance() {
        return INSTANCE;
    }

    private ProductRepository() {}
}
