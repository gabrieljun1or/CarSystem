package com.carmanagement.system.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@Table(name = "tb_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "brand is mandatory")
    private String brand;
    @NotBlank(message = "Color is mandatory")
    private String color;
    @NotBlank(message = "year is mandatory")
    private int ano;
    @NotBlank(message = "price is mandatory")
    private long price;


}
