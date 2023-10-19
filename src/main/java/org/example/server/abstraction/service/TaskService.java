package org.example.server.abstraction.service;

import org.example.server.repository.TaskRepo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.List;

public interface TaskService {
    Mono<TaskDto> getById(Long id);

    Mono<Long> addTask(AddTaskDto addTaskDto);
    Mono<Void> deleteTask(Long id);
    Mono<Long> updateTask(EditTaskDto editEventDto, Long id);
    Flux<TaskDto> getByType(Integer type);

    Flux<TaskDto> getByDeadline(Instant deadline);
    Mono<List<TaskDto>> getDay(Instant datetime);
    Flux<TaskDto> getWeek(Instant datetime);

    record AddTaskDto(
            Long id_user,
            String message,
            Integer type,
            Instant deadline,
            Boolean isdone
    ){
        public static TaskRepo.Task toDbEntity(AddTaskDto addTaskDto){
            return new TaskRepo.Task(
                    null,
                    addTaskDto.id_user(),
                    addTaskDto.message(),
                    addTaskDto.type(),
                    addTaskDto.deadline(),
                    false
            );
        }
    }

    record TaskDto(
            Long id,
            Long id_user,
            String message,
            Integer type,
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

    record EditTaskDto(
            Long id_user,
            String message,
            Integer type,
            Instant deadline,
            Boolean isdone
    ){
        public static TaskRepo.Task toDbEntity(EditTaskDto editTaskDto, Long id){
            return new TaskRepo.Task(
                    id,
                    editTaskDto.id_user(),
                    editTaskDto.message(),
                    editTaskDto.type(),
                    editTaskDto.deadline(),
                    false
            );
        }
    }

}