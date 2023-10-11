package org.example.controller;

import org.example.abstraction.service.TaskService;
import org.example.abstraction.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public record TaskController(
        TaskService taskService
) {
    @GetMapping("/getTask/{id}")
    public Mono<TaskService.TaskDto> findByid(@PathVariable Long id){
        return taskService.getById(id);
    }

    @PostMapping("/addTask")
    public Mono<Long> findById(@RequestBody TaskService.AddTaskDto addTaskDto) {return taskService.addTask(addTaskDto);}

    @DeleteMapping("/deleteTask/{id}")
    public Mono<Void> deleteById(@PathVariable Long id) {return taskService.deleteTask(id);}

    @PostMapping("/updateTask/{id}")
    public Mono<Long> updateById(@RequestBody TaskService.EditTaskDto editEventDto, @PathVariable Long id) {return taskService.updateTask(editEventDto, id);}
}
