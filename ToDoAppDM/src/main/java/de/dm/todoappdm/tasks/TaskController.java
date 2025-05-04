package de.dm.todoappdm.tasks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }



    @GetMapping
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        return taskService.getById(id);
    }



    @PostMapping
    public ResponseEntity<Task> create(@RequestParam String description,
                                       @RequestParam(required = false) Long idShelfFrom,
                                       @RequestParam(required = false) Long idShelfTo,
                                       @RequestParam(required = false) Long idProduct) {

        Task created = taskService.create(description, idShelfFrom, idShelfTo, idProduct);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }



    @PutMapping("/{id}")
    public Task update(@PathVariable Long id,
                       @RequestParam String description,
                       @RequestParam(required = false) Long idShelfFrom,
                       @RequestParam(required = false) Long idShelfTo,
                       @RequestParam(required = false) Long idProduct) {

        return taskService.update(id, description, idShelfFrom, idShelfTo, idProduct);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
