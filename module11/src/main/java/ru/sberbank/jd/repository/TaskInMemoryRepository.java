package ru.sberbank.jd.repository;

import org.springframework.stereotype.Repository;
import ru.sberbank.jd.model.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class TaskInMemoryRepository implements TaskRepository {
    private final Map<String, Task> storage = new HashMap<>();
    @Override
    public Task save(Task task) {
        storage.put(task.getId(), task);
        return task;
    }

    @Override
    public Optional<Task> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }
}
