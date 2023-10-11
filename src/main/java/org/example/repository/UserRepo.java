package org.example.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends ReactiveCrudRepository<UserRepo.User, Long> {

    @Table("user")
    record User(
            @Id
            Long id,
            String fname,

            String sname,

            String login,

            String password
    ){}
}
