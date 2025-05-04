package de.dm.todoappdm.locationOfItems;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@Transactional
public class LocationOfItemsService {
    private final LocationOfItemsRepository repository;

    public LocationOfItemsService(LocationOfItemsRepository repository) {
        this.repository = repository;
    }

    public List<LocationOfItems> findAll() {
        return repository.findAll();
    }

    public LocationOfItems findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public LocationOfItems create(LocationOfItems entity) {
        return repository.save(entity);
    }

    public LocationOfItems update(Long id, LocationOfItems entity) {
        LocationOfItems existing = findById(id);
        existing.setIdItem(entity.getIdItem());
        existing.setIdShelves(entity.getIdShelves());
        return repository.save(existing);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
    }
}