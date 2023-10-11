package org.example.abstraction.service;

import org.example.repository.TaskRepo;
import reactor.core.publisher.Mono;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;

public interface TaskService {
    Mono<TaskDto> getById(Long id);

    Mono<Long> addTask(AddTaskDto addTaskDto);

    record AddTaskDto(
            Long id_user,
            String message,
            Integer tupe,
            Instant deadline,
            Boolean isdone
    ){
        public static TaskRepo.Task toDbEntity(AddTaskDto addTaskDto){
            return new TaskRepo.Task(
                    null,
                    addTaskDto.id_user(),
                    addTaskDto.message(),
                    addTaskDto.tupe(),
                    addTaskDto.deadline(),
                    false
            );
        }
    }

    record TaskDto(
            Long id,
            Long id_user,
            String message,
            Integer tupe,
            Instant deadline,
            Boolean isdone
    ){
        public static TaskDto fromDbEntity(TaskRepo.Task task){
            return new TaskDto(
                    task.id(),
                    task.id_user(),
                    task.message(),
                    task.type(),
                    task.deadline(),
                    task.isdone()
            );
        }
    }

}