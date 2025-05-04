package de.dm.todoappdm.assigned;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignedTaskRepository extends JpaRepository<AssignedTask, Long> {
    List<AssignedTask> findByUser_IdUser(Long idUser);
}
