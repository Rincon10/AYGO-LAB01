package com.escuelaing.edu.co.distribuited_systems.user.services;

import com.escuelaing.edu.co.distribuited_systems.user.models.NameRequest;
import com.escuelaing.edu.co.distribuited_systems.user.models.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User addUser(NameRequest nameRequest);
}
