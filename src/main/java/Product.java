package src.main.java;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private int sellerId;

    public Product(int id, String name, double price, int quantity, int sellerId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.sellerId = sellerId;
    }
    
        //**Getters and setters */ 
        
        //**Get Product */ 
        public int getId() {
            return id;
        }
    
        //**Set Product */ 
        public void setId(int product) {
            this.id = product;
        }
    
        //**Get Name */ 
        public String getName() {
            return name;
        }
    
        //**Set Name */ 
        public void setName(String name) {
            this.name = name;
        }
    
        //**Get price */ 
        public double getPrice() {
            return price;
        }
    
        //**Set Price */ 
        public void setPrice (double price) {
            this.price = price;
        }
    
        //**Get Quantity */ 
        public int getQuantity() {
            return quantity;
        }
    
        //**Set Quantity */ 
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }


        //**Get SellerId */ 
        public int getSellerId() {
            return sellerId;
        }
    
        //**Set SellerId */ 
        public void setSellerId (int sellerId) {
            this.sellerId = sellerId;  
         }

         //** Update Details of Products */
         
}
