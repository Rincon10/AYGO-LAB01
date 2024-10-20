package com.escuelaing.edu.co.distribuited_systems.services.impl;

import com.escuelaing.edu.co.distribuited_systems.clients.UsersClientRest;
import com.escuelaing.edu.co.distribuited_systems.dtos.response.ResponseDTO;
import com.escuelaing.edu.co.distribuited_systems.models.NameRequest;
import com.escuelaing.edu.co.distribuited_systems.models.User;
import com.escuelaing.edu.co.distribuited_systems.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 10/20/2024
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UsersClientRest usersClientRest;

    @Override
    public ResponseDTO<User> registerName(String name) {
        NameRequest nameRequest = NameRequest.builder().name(name).build();

        ResponseDTO<User> userResponseDTO = usersClientRest.registerUser(nameRequest);
        return userResponseDTO;
    }
}
