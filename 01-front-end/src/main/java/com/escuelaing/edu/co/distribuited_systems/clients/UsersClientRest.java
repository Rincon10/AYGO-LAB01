package com.escuelaing.edu.co.distribuited_systems.clients;

import com.escuelaing.edu.co.distribuited_systems.dtos.response.ResponseDTO;
import com.escuelaing.edu.co.distribuited_systems.models.NameRequest;
import com.escuelaing.edu.co.distribuited_systems.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 10/20/2024
 */
@FeignClient(name = "servicio-usuarios")
public interface UsersClientRest {

    @PostMapping("/api/register")
    ResponseDTO<User> registerUser(@RequestBody NameRequest nameRequest);
}
