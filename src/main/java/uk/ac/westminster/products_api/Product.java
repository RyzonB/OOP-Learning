package uk.ac.westminster.products_api;

public class Product {

    private Long id;
    private String name;
    private double price;

    public Product () {}
    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {return id;}
    public String getName() {return name;} // When commented out, Jackson sees no getter so it skips the field and nothing is displayed.
    public double getPrice() {return price;}
}
