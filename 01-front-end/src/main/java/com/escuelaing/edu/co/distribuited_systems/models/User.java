package com.escuelaing.edu.co.distribuited_systems.models;

import lombok.*;

import java.util.Date;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 10/20/2024
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User {

    private String name;
    private Date timeStamp;
}
