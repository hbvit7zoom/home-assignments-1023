package ru.sberbank.jd.service;

import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import ru.sberbank.jd.controller.TaskController;
import ru.sberbank.jd.controller.input.TaskInput;
import ru.sberbank.jd.model.Task;
import ru.sberbank.jd.repository.TaskRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task createTask(@NonNull TaskInput taskInput) {
        Task task = Task.of(taskInput);
        taskRepository.save(task);
        return task;
    }

    public Task getTask(String id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }
}
