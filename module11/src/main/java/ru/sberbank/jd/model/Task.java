package ru.sberbank.jd.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.sberbank.jd.controller.input.TaskInput;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Task {
    private String id;
    private final String owner;
    private final LocalDateTime createdDateTime;
    private String summary;
    private String description;
    private TaskStatus taskStatus;

    public static Task of(TaskInput input) {
        return new TaskBuilder()
                .id(UUID.randomUUID().toString())
                .summary(input.summary())
                .description(input.description())
                .owner(input.owner())
                .createdDateTime(LocalDateTime.now())
                .taskStatus(TaskStatus.NEW)
                .build();
    }
}
