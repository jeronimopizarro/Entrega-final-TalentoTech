package com.techlab.e_commerce.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductDomain {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String category;
    private Integer stock;
}
