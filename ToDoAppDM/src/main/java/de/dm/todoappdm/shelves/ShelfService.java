package de.dm.todoappdm.shelves;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional
public class ShelfService {

    private final ShelfRepository repository;

    public ShelfService(ShelfRepository repository) {
        this.repository = repository;
    }

    public List<Shelf> findAll() {
        return repository.findAll();
    }

    public Shelf findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Shelf %d not found".formatted(id)));
    }

    public Shelf create(Shelf shelf) {
        return repository.save(shelf);
    }

    public Shelf update(Long id, Shelf data) {
        Shelf existing = findById(id);
        existing.setDescription(data.getDescription());
        return repository.save(existing);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Shelf %d not found".formatted(id));
        }
        repository.deleteById(id);
    }
}
