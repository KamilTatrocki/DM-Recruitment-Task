package de.dm.todoappdm.assigned;

import de.dm.todoappdm.tasks.Task;
import de.dm.todoappdm.users.User;
import jakarta.persistence.*;

@Entity
@Table(name = "ASSIGNED_TASK")
public class AssignedTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDASSIGNED")
    private Long idAssigned;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IDTASK", nullable = false)
    private Task task;

    @ManyToOne(optional = false)
    @JoinColumn(name = "IDUSER", nullable = false)
    private User user;

    @Column(name = "ISDONE", nullable = false)
    private boolean isdone = false;


    public AssignedTask() { }

    public AssignedTask(Task task, User user, boolean isdone) {
        this.task = task;
        this.user = user;
        this.isdone = isdone;
    }


    public Long getIdAssigned() { return idAssigned; }

    public Task getTask() { return task; }
    public void setTask(Task task) { this.task = task; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public boolean isDone() { return isdone; }
    public void setDone(boolean done) { this.isdone = done; }
}
