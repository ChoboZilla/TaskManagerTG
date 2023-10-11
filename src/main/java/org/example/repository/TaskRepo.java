package org.example.repository;

import org.example.abstraction.service.TaskService;
import org.springframework.data.annotation.Id;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;

@Repository
public interface TaskRepo extends ReactiveCrudRepository<TaskRepo.Task, Long> {

    @Table("task")
    record Task(
            @Id
            Long id,
            Long id_user,
            String message,
            Integer type,
            Instant deadline,
            Boolean isdone
    ){}
    Flux<TaskRepo.Task>findByType(@Param("type") Integer type);
    Flux<TaskRepo.Task> findByDeadline(Instant deadline);
    @Query("SELECT * " +
            "FROM task " +
            "WHERE task.deadline < :datetime " +
            "ORDER BY task.deadline")
    Flux<TaskRepo.Task> findAllByDeadlineLessThan(Instant deadline); //Для поиска в пределах дня, недели
}