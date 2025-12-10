package com.techlab.e_commerce.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ErrorResponseDTO {
    private String title;
    private String message;
}
