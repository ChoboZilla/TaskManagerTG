package org.example.abstraction.service;

import org.example.repository.UserRepo;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserDto> getById(Long id);

    record UserDto(
            Long id,
            String fname,

            String sname,

            String login,

            String password
    ){
        public static UserDto fromDbEntity(UserRepo.User user){
            return new UserDto(
                    user.id(),
                    user.fname(),
                    user.sname(),
                    user.login(),
                    user.password()
            );
        }
    }
}
