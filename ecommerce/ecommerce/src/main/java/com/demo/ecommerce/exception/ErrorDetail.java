package com.demo.ecommerce.exception;

import java.time.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ErrorDetail {

    private String error;
    private String  details;
    private LocalDateTime timestamp;


}
