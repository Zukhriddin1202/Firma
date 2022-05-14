package com.example.firma.Dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class IshchiFirma {
    private String ismi;
    private String telNomer;
    private String lavozim;
    private double maosh;
    private String manzil;
    private Integer firmaId;
}
