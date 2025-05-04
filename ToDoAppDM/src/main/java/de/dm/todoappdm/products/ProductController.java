package de.dm.todoappdm.products;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }



    @GetMapping
    public List<Product> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable Long id) {
        return service.findById(id);
    }



    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product saved = service.create(product);
        URI location = URI.create("/api/products/" + saved.getIdProduct());
        return ResponseEntity.created(location).body(saved);
    }



    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return service.update(id, product);
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
