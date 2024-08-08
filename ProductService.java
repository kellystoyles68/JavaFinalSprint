import java.util.List;

/**
 * Service class for managing products.
 * Acts as a bridge between the presentation layer and the data access layer.
 */
public class ProductService {
    private ProductDAO productDAO;

    /**
     * Constructs a new ProductService and initializes the ProductDAO.
     */
    public ProductService() {
        this.productDAO = new ProductDAO();
    }

    /**
     * Adds a new product to the database.
     * @param name the name of the product
     * @param price the price of the product
     * @param quantity the quantity of the product
     * @param sellerId the ID of the seller
     */
    public void addProduct(String name, double price, int quantity, int sellerId) {
        Product product = new Product(name, price, quantity, sellerId);
        productDAO.addProduct(product);
    }

    /**
     * Retrieves a product by its ID.
     * @param id the ID of the product
     * @return the product with the specified ID, or null if not found
     */
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    /**
     * Retrieves products by their name.
     * @param name the partial name to search for
     * @return a list of products matching the partial name
     */
    public List<Product> getProductsByName(String name) {
        return productDAO.getProductsByName(name);
    }

    /**
     * Retrieves all products from the database.
     * @return a list of all products
     */
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }
    
    /**
     * Retrieves all products with their seller information from the database.
     * @return a list of all products with seller information
     */
    public List<Product> getAllProductsWithSellerInfo() {
        return productDAO.getAllProductsWithSellerInfo();
    }

    /**
     * Updates an existing product in the database.
     * @param product the product to update
     */
    public void updateProduct(Product product) {
        productDAO.updateProduct(product);
    }

    /**
     * Deletes a product from the database by its ID.
     * @param id the ID of the product to delete
     */
    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
    }
}
