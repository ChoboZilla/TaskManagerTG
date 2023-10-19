package org.hsai.server.abstraction.serviceimpl;

import org.hsai.server.abstraction.service.UserService;
import org.hsai.server.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public Mono<UserDto> getById(Long id) {
        return userRepo
                .findById(id)
                .map(UserDto::fromDbEntity);
    }
    @Override
    public Mono<Long> addUser(UserService.AddUserDto addUserDto) {
        return userRepo
                .save(UserService.AddUserDto.toDbEntity(addUserDto))
                .map(UserRepo.User::id);
    }

    @Override
    public Mono<UserDto> signIn(UserService.SignInDto signInDto) {
        return userRepo
                .signIn(signInDto.login(), signInDto.password())
                .map(UserDto::fromDbEntity);
    }
}
