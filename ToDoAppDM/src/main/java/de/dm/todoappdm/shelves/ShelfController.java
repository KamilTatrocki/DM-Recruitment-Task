package de.dm.todoappdm.shelves;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/shelves")
public class ShelfController {

    private final ShelfService service;

    public ShelfController(ShelfService service) {
        this.service = service;
    }

    @GetMapping
    public List<Shelf> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Shelf getOne(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Shelf> create(@RequestBody Shelf shelf) {
        Shelf saved = service.create(shelf);
        URI location = URI.create("/api/shelves/" + saved.getId());
        return ResponseEntity.created(location).body(saved);
    }

    @PutMapping("/{id}")
    public Shelf update(@PathVariable Long id, @RequestBody Shelf shelf) {
        return service.update(id, shelf);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
