package de.dm.todoappdm.assigned;

import de.dm.todoappdm.tasks.Task;
import de.dm.todoappdm.tasks.TaskRepository;
import de.dm.todoappdm.users.User;
import de.dm.todoappdm.users.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AssignedTaskService {

    private final AssignedTaskRepository assignedRepo;
    private final TaskRepository taskRepo;
    private final UserRepository userRepo;

    public AssignedTaskService(AssignedTaskRepository assignedRepo,
                               TaskRepository taskRepo,
                               UserRepository userRepo) {
        this.assignedRepo = assignedRepo;
        this.taskRepo     = taskRepo;
        this.userRepo     = userRepo;
    }


    public AssignedTask assign(Long idTask, Long idUser) {
        Task task = taskRepo.findById(idTask)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        User user = userRepo.findById(idUser)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        AssignedTask at = new AssignedTask(task, user, false);
        return assignedRepo.save(at);
    }

    public List<AssignedTask> getAll() {
        return assignedRepo.findAll();
    }

    public List<AssignedTask> getByUser(Long idUser) {
        return assignedRepo.findByUser_IdUser(idUser);
    }

    public AssignedTask get(Long id) {
        return assignedRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Assignment not found"));
    }


    public AssignedTask setDone(Long idAssigned, boolean done) {
        AssignedTask at = get(idAssigned);
        at.setDone(done);
        return assignedRepo.save(at);
    }


    public void delete(Long idAssigned) {
        assignedRepo.deleteById(idAssigned);
    }
}
