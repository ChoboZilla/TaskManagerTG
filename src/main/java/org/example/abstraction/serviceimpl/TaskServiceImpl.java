package org.example.abstraction.serviceimpl;

import org.example.abstraction.service.TaskService;
import org.example.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepo taskRepo;

    @Override
    public Mono<TaskDto> getById(Long id) {
        return taskRepo
                .findById(id)
                .map(TaskDto::fromDbEntity);
    }

    @Override
    public Mono<Long> addTask(AddTaskDto addTaskDto) {
        return taskRepo
                .save(AddTaskDto.toDbEntity(addTaskDto))
                .map(TaskRepo.Task::id);
    }
}
