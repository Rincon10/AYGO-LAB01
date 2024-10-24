package com.escuelaing.edu.co.distribuited_systems.user.services;

import com.escuelaing.edu.co.distribuited_systems.user.models.NameRequest;
import com.escuelaing.edu.co.distribuited_systems.user.models.User;
import com.escuelaing.edu.co.distribuited_systems.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 10/23/2024
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(NameRequest nameRequest) {
        User user = User.builder()
                .name(nameRequest.getName())
                .timeStamp(new Date())
                .build();
        return userRepository.insert(user);
    }
}
