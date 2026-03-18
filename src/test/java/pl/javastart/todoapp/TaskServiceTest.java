package pl.javastart.todoapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javastart.todoapp.model.Task;
import pl.javastart.todoapp.repository.TaskRepository;
import pl.javastart.todoapp.service.TaskService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void shouldReturnAllTasks() {
        Task task = new Task();
        task.setTitle("Zadanie testowe");
        when(taskRepository.findAll()).thenReturn(List.of(task));

        List<Task> result = taskService.getAllTasks();

        assertEquals(1, result.size());
        assertEquals("Zadanie testowe", result.get(0).getTitle());
    }

    @Test
    void shouldReturnTaskById() {
        Task task = new Task();
        task.setTitle("Szukane zadanie");
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Optional<Task> result = taskService.getById(1L);

        assertTrue(result.isPresent());
        assertEquals("Szukane zadanie", result.get().getTitle());
    }

    @Test
    void shouldReturnEmptyWhenTaskNotFound() {
        when(taskRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Task> result = taskService.getById(99L);

        assertFalse(result.isPresent());
    }

    @Test
    void shouldCreateTask() {
        Task task = new Task();
        task.setTitle("Nowe zadanie");
        when(taskRepository.save(task)).thenReturn(task);

        Task result = taskService.createTask(task);

        assertEquals("Nowe zadanie", result.getTitle());
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void shouldDeleteTaskWhenExists() {
        when(taskRepository.existsById(1L)).thenReturn(true);

        boolean result = taskService.deleteTask(1L);

        assertTrue(result);
        verify(taskRepository, times(1)).deleteById(1L);
    }

    @Test
    void shouldReturnFalseWhenDeletingNonExistentTask() {
        when(taskRepository.existsById(99L)).thenReturn(false);

        boolean result = taskService.deleteTask(99L);

        assertFalse(result);
        verify(taskRepository, never()).deleteById(any());
    }
}
