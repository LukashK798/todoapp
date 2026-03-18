package pl.javastart.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.javastart.todoapp.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
