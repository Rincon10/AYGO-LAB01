package com.escuelaing.edu.co.distribuited_systems.controllers;

import com.escuelaing.edu.co.distribuited_systems.services.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 10/20/2024
 */

@RestController
@Slf4j
public class RegisterRestController {
    @Autowired
    private RegisterService registerService;




}
