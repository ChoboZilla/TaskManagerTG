package org.example.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface TaskRepo extends ReactiveCrudRepository<TaskRepo.Task, Long> {

    @Table("tasks")
    record Task(
            @Id
            Long id,
            Long userId,
            String comments,
            Instant createdAt,
            Instant deadline,
            Boolean isDone
    ){}
}