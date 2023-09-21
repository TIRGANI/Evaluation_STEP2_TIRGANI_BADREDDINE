package com.example.evaluation_step2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Author: Badreddine Tirgani
 * Date: 21/09/2023
 */
@Data
@AllArgsConstructor
public class Salary {
    private int id;
    private int annee;
    private int mois;
    private double salaireMensuel;
}
