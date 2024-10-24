package com.escuelaing.edu.co.distribuited_systems.user.repositories;

import com.escuelaing.edu.co.distribuited_systems.user.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
