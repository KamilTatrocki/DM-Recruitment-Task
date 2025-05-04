package de.dm.todoappdm.items;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> findAllSortedByExpiration() {
        return repository.findAllByOrderByExpirationDateAsc();
    }

    public List<Item> findAll() {
        return repository.findAll();
    }

    public Item findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Item %d not found".formatted(id)));
    }

    public Item create(Item item) {
        return repository.save(item);
    }

    public Item update(Long id, Item data) {
        Item existing = findById(id);
        existing.setExpirationDate(data.getExpirationDate());
        existing.setProduct(data.getProduct());
        return repository.save(existing);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Item %d not found".formatted(id));
        }
        repository.deleteById(id);
    }
}
