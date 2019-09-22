package com.rnd.backendspring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private LocalDateTime timeStamp;
    private String status;
    private int code;
    private T data;

    public static final ApiResponse badRequestException(){
        ApiResponse apiResponse = ApiResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status("sorry something wrong !")
                .code(400)
                .data(null)
                .build();
        return apiResponse;
    }

    public static final ApiResponse okRequestException(Object obj){
        ApiResponse apiResponse = ApiResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status("yeay success !!")
                .code(200)
                .data(obj)
                .build();
        return apiResponse;
    }
}
