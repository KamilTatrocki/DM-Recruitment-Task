package de.dm.todoappdm.assigned;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/assigned")
public class AssignedTaskController {

    private final AssignedTaskService service;

    public AssignedTaskController(AssignedTaskService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<AssignedTask> assign(@RequestParam Long taskId,
                                               @RequestParam Long userId) {
        AssignedTask created = service.assign(taskId, userId);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


    @GetMapping
    public List<AssignedTask> getAll() {
        return service.getAll();
    }


    @GetMapping("/user/{userId}")
    public List<AssignedTask> byUser(@PathVariable Long userId) {
        return service.getByUser(userId);
    }


    @PutMapping("/{id}/done")
    public AssignedTask setDone(@PathVariable Long id,
                                @RequestParam boolean value) {
        return service.setDone(id, value);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
