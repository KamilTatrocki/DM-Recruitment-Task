package de.dm.todoappdm.locationOfItems;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/locationOfItems")
public class LocationOfItemsController {
    private final LocationOfItemsService service;

    public LocationOfItemsController(LocationOfItemsService service) {
        this.service = service;
    }

    @GetMapping
    public List<LocationOfItems> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public LocationOfItems getOne(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<LocationOfItems> create(@RequestBody LocationOfItems entity) {
        LocationOfItems saved = service.create(entity);
        URI location = URI.create("/api/locationOfItems/" + saved.getIdLocation());
        return ResponseEntity.created(location).body(saved);
    }

    @PutMapping("/{id}")
    public LocationOfItems update(@PathVariable Long id, @RequestBody LocationOfItems entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}