package comasr.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.asr.service.ProductService;

import comasr.Model.Product;
import comasr.Model.Rating;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product createdProduct = productService.addProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam(required = false) String name,
                                                        @RequestParam(required = false) String category,
                                                        @RequestParam(required = false) Map<String, String> attributes) {
        List<Product> products = productService.searchProducts(name, category, attributes);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/{id}/rate")
    public ResponseEntity<Product> rateProduct(@PathVariable Long id, @RequestBody Rating rating) {
        Product ratedProduct = productService.rateProduct(id, rating);
        if (ratedProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ratedProduct, HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Product>> sortProducts(@RequestParam String sortBy) {
        List<Product> sortedProducts = productService.sortProducts(sortBy);
        return new ResponseEntity<>(sortedProducts, HttpStatus.OK);
    }
}

