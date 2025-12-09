package com.techlab.e_commerce.utils;

import org.springframework.stereotype.Component;

@Component
public class StringUtils {

    public boolean isEmpty(String textToValidate) {
        return textToValidate == null || textToValidate.isBlank();
    }
}
