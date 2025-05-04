package de.dm.todoappdm.tasks;

import de.dm.todoappdm.products.Product;
import de.dm.todoappdm.products.ProductRepository;
import de.dm.todoappdm.shelves.Shelf;
import de.dm.todoappdm.shelves.ShelfRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;
    private final ShelfRepository shelfRepository;
    private final ProductRepository productRepository;

    public TaskService(TaskRepository taskRepository,
                       ShelfRepository shelfRepository,
                       ProductRepository productRepository) {
        this.taskRepository    = taskRepository;
        this.shelfRepository   = shelfRepository;
        this.productRepository = productRepository;
    }



    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task " + id + " not found"));
    }

    public Task create(String description,
                       Long idShelfFrom,
                       Long idShelfTo,
                       Long idProduct) {

        Shelf   shelfFrom = fetchShelf(idShelfFrom).orElse(null);
        Shelf   shelfTo   = fetchShelf(idShelfTo).orElse(null);
        Product product   = fetchProduct(idProduct).orElse(null);

        Task task = new Task(description, shelfFrom, shelfTo, product);
        return taskRepository.save(task);
    }

    public Task update(Long id,
                       String description,
                       Long idShelfFrom,
                       Long idShelfTo,
                       Long idProduct) {

        Task existing = getById(id);

        existing.setDescription(description);
        existing.setShelfFrom(fetchShelf(idShelfFrom).orElse(null));
        existing.setShelfTo(fetchShelf(idShelfTo).orElse(null));
        existing.setProduct(fetchProduct(idProduct).orElse(null));

        return taskRepository.save(existing);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }



    private Optional<Shelf> fetchShelf(Long id) {
        return id == null ? Optional.empty()
                : shelfRepository.findById(id);
    }

    private Optional<Product> fetchProduct(Long id) {
        return id == null ? Optional.empty()
                : productRepository.findById(id);
    }
}
