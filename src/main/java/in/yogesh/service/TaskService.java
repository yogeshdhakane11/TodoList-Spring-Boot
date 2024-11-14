package in.yogesh.service;

import in.yogesh.models.Task;
import in.yogesh.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService{
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTask(String tittle) {
        Task task = new Task();
        task.setTittle(tittle);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Task"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
