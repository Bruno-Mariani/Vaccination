package com.zup.vaccination.controllers;

import com.zup.vaccination.dtos.CreateUserDto;
import com.zup.vaccination.dtos.UserResponse;
import com.zup.vaccination.exceptions.UniqueKeyViolationException;
import com.zup.vaccination.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<UserResponse> create(@RequestBody() @Valid() CreateUserDto userDto) throws UniqueKeyViolationException {
        return new ResponseEntity<>(
                UserResponse.from(this.userService.create(userDto)),
                HttpStatus.CREATED
        );
    }
}
