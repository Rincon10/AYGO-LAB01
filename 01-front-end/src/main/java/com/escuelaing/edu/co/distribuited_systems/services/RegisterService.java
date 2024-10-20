package com.escuelaing.edu.co.distribuited_systems.services;

import com.escuelaing.edu.co.distribuited_systems.dtos.response.ResponseDTO;
import com.escuelaing.edu.co.distribuited_systems.models.User;

public interface RegisterService {

    ResponseDTO<User> registerName(String name);
}
