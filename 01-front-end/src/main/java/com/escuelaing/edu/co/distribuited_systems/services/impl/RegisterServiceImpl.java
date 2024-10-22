package com.escuelaing.edu.co.distribuited_systems.services.impl;

import com.escuelaing.edu.co.distribuited_systems.clients.GatewayClientRest;
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
    private GatewayClientRest usersClientRest;

    @Override
    public ResponseDTO<User> registerName(NameRequest nameRequest) {
        ResponseDTO<User> userResponseDTO = usersClientRest.registerUser(nameRequest);
        return userResponseDTO;
    }
}
