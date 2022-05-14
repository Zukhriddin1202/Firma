package com.example.firma.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Ishchi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Telefon maydonchasini to'ldiring")
    private String ismi;
    @NotNull(message = "Telefon maydonchasini to'ldiring")
    private String telNomer;
    @NotNull(message = "Lavozim maydonchasini to'ldiring")
    private String lavozim;
    @NotNull(message = "Maosh maydonchasini to'ldiring")
    private double maosh;
    @NotNull(message = "Manzil maydonchasini to'ldiring")
    private String manzil;
    @NotNull(message = "Firma maydonchasini to'ldiring")
    @ManyToOne
    Firma firma;


}
