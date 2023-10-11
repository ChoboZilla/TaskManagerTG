package org.example.abstraction.service;

import org.example.repository.TaskRepo;
import reactor.core.publisher.Mono;

import java.time.Instant;

public interface TaskService {
    Mono<TaskDto> getById(Long id);

    Mono<Long> addTask(AddTaskDto addTaskDto);

    record AddTaskDto(
            Long userId,
            String comments,
            Instant deadline
    ){
        public static TaskRepo.Task toDbEntity(AddTaskDto addTaskDto){
            return new TaskRepo.Task(
                    null,
                    addTaskDto.userId(),
                    addTaskDto.comments(),
                    Instant.now(),
                    addTaskDto.deadline(),
                    false
            );
        }
    }

    record TaskDto(
            Long id,
            Long userId,
            String comments,
            Instant createdAt,
            Instant deadline
    ){
        public static TaskDto fromDbEntity(TaskRepo.Task task){
            return new TaskDto(
                    task.id(),
                    task.userId(),
                    task.comments(),
                    task.createdAt(),
                    task.deadline()
            );
        }
    }

}