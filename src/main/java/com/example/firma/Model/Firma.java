package com.example.firma.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Firma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Korxona nomi maydonchasini to'ldiring")
    private String nomi;
    @NotNull(message = "Korxona egasi maydonchasini to'ldiring")
    private String egasi;
    @NotNull(message = "Korxona manzili maydonchasini to'ldiring")
    private String manzil;


}
