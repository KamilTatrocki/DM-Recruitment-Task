package de.dm.todoappdm.items;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }



    @GetMapping
    public List<Item> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Item getOne(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/soonest")
    public List<Item> getAllSorted() {
        return service.findAllSortedByExpiration();
    }

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody Item item) {
        Item saved = service.create(item);
        URI location = URI.create("/api/items/" + saved.getIdItem());
        return ResponseEntity.created(location).body(saved);
    }


    @PutMapping("/{id}")
    public Item update(@PathVariable Long id, @RequestBody Item item) {
        return service.update(id, item);
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
