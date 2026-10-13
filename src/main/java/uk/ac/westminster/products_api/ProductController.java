package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    private ProductService productservice;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productservice.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productservice.getProductById(id).orElse(null);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productservice.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct (@PathVariable Long id){
        productservice.deleteProduct(id);
    }

    @GetMapping("/products/search")
    public List<Product> search (@RequestParam String name){
        return productservice.findByName(name);
    }
}

