package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public List<Product> getAllProducts() {
        return products;
    }


    public ProductService() { // They came from the Product superclass via its inherited getters, which Jackson used to serialize them into JSON.
        products.add(new DigitalProduct(nextId++,"Manga",25.0,"http://mangascans.com",4.3));
        products.add(new PhysicalProduct(nextId++, "Laptop",999.99,2.8,"1920x1080"));
    }
    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id){
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();

    }

    public void deleteProduct(Long id){
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name){
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }


}
