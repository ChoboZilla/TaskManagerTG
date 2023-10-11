package org.example.abstraction.serviceimpl;

import org.example.abstraction.service.UserService;
import org.example.repository.UserRepo;
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
}
