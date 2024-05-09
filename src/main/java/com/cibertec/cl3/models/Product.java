package com.cibertec.cl3.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "producto")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion", nullable = false)
    private String description;

    @Column(name = "fec_registro", columnDefinition = "DATE", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "precio", columnDefinition = "DOUBLE", nullable = false)
    private double price;

    @Column(name = "stock", columnDefinition = "INT", nullable = false)
    private int stock;

    @PrePersist
    public void setDefaultValues() {
        this.registrationDate = LocalDate.now();
    }
}
