package org.example.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

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
}