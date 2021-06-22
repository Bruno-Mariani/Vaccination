package com.zup.vaccination.services;


import com.zup.vaccination.dtos.CreateUserDto;
import com.zup.vaccination.exceptions.UniqueKeyViolationException;
import com.zup.vaccination.models.User;
import com.zup.vaccination.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(CreateUserDto userDto) throws UniqueKeyViolationException {

        Optional<User> userByEmail = userRepository.findByEmail(userDto.getEmail());

        if (userByEmail.isPresent()){
            throw new UniqueKeyViolationException("Email in use.");
        }

        User user = new User(
                null,
                userDto.getName(),
                userDto.getEmail(),
                userDto.getCpf(),
                userDto.getDayOfBirth(),
                null
        );

        return this.userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {

        return this.userRepository.findByEmail(email);

    }

}
