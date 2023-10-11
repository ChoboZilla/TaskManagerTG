package org.example.abstraction.service;

import org.example.repository.UserRepo;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserDto> getById(Long id);
    Mono<Long> addUser(UserService.AddUserDto addUserDto);

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

    record AddUserDto(
            String fname,

            String sname,

            String login,

            String password
    ){
        public static UserRepo.User toDbEntity(UserService.AddUserDto addUserDto){
            return new UserRepo.User(
                    null,
                    addUserDto.fname(),
                    addUserDto.sname(),
                    addUserDto.login(),
                    addUserDto.password()
            );
        }
    }
}
