package com.example.spring_boot.demo2.contract;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response<T> {
    private T payload;
    private String message;
    
}
