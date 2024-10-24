package com.escuelaing.edu.co.distribuited_systems.user.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 10/23/2024
 */
@Document(collection = "users")
@Data
@Builder
public class User {

    @Id
    private String id;

    private String name;
    private Date timeStamp;
}
