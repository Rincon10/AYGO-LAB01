package com.escuelaing.edu.co.distribuited_systems.controllers;

import com.escuelaing.edu.co.distribuited_systems.dtos.response.ResponseDTO;
import com.escuelaing.edu.co.distribuited_systems.models.NameRequest;
import com.escuelaing.edu.co.distribuited_systems.models.User;
import com.escuelaing.edu.co.distribuited_systems.services.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 10/20/2024
 */

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RegisterRestController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO<User>> register(@RequestBody NameRequest nameRequest) {
        ResponseDTO<User> responseDTO = registerService.registerName(nameRequest);
        return ResponseEntity.ok().body(responseDTO);
    }
}
