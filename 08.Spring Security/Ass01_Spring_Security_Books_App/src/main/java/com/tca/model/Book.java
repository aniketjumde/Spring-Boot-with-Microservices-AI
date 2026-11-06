package com.tca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Book {

    @Id
    private Integer id;
    private String title;
    private Double price;
}
