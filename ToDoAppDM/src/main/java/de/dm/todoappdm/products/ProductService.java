package de.dm.todoappdm.products;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }



    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Product %d not found".formatted(id)));
    }

    public Product create(Product p) {
        return repository.save(p);
    }

    public Product update(Long id, Product data) {
        Product existing = findById(id);
        existing.setNameProduct(data.getNameProduct());
        existing.setCategory(data.getCategory());
        return repository.save(existing);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Product %d not found".formatted(id));
        }
        repository.deleteById(id);
    }
}
