package com.escuelaing.edu.co.distribuited_systems.user.controllers;

import com.escuelaing.edu.co.distribuited_systems.user.dtos.response.ResponseDTO;
import com.escuelaing.edu.co.distribuited_systems.user.models.NameRequest;
import com.escuelaing.edu.co.distribuited_systems.user.models.User;
import com.escuelaing.edu.co.distribuited_systems.user.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 10/23/2024
 */
@RestController
@Slf4j
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseDTO<User> addUser(@RequestBody NameRequest nameRequest) {
        ResponseDTO<User> responseDTO = ResponseDTO.<User>builder()
                .data(List.of(userService.addUser(nameRequest)))
                .description(HttpStatus.OK.getReasonPhrase()).status(HttpStatus.OK.value()).build();
        return responseDTO;
    }

    @GetMapping("/list")
    public ResponseDTO<User> obtenerUsuarios() {
        List<User> users = userService.findAllUsers();

        ResponseDTO<User> responseDTO = ResponseDTO.<User>builder()
                .data(users)
                .description(HttpStatus.OK.getReasonPhrase()).status(HttpStatus.OK.value()).build();
        return responseDTO;
    }
}
