/**
 * Represents a Product in the E-Commerce platform.
 */
public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private int sellerId;
    private String sellerName;

    /**
     * Default constructor for creating a new Product.
     */
    public Product() {}

    public Product(String name, double price, int quantity, int sellerId) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sellerId = sellerId;
    }

    /**
     * Gets the product ID.
     * @return the product ID
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the product ID.
     * @param id the product ID
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Gets the product name.
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the product name.
     * @param name the product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the product price.
     * @return the product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the product price.
     * @param price the product price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the product quantity.
     * @return the product quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the product quantity.
     * @param quantity the product quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the seller ID.
     * @return the seller ID
     */
    public int getSellerId() {
        return sellerId;
    }

    /**
     * Sets the seller ID.
     * @param sellerId the seller ID
     */
    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * Gets the seller name.
     * @return the seller name
     */
    public String getSellerName() {
        return sellerName;
    }

    /**
     * Sets the seller name.
     * @param sellerName the seller name
     */
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}