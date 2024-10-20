package com.escuelaing.edu.co.distribuited_systems.dtos.response;

import lombok.*;

import java.util.List;

/**
 * @author Ivan Camilo Rincon Saavedra
 * @version 1.0
 * @since 10/20/2024
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO<T> {
    private int status;

    private String description;

    private List<T> data;
}
