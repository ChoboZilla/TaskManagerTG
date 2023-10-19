package org.example.server.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.Instant;

@Repository
public interface TaskRepo extends ReactiveCrudRepository<TaskRepo.Task, Long> {

    @Table("task")
    record Task(
            @Id
            Long id,
            Long idUser,
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