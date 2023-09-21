package com.example.evaluation_step2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Author: Badreddine Tirgani
 * Date: 21/09/2023
 */

    @Data
    @AllArgsConstructor
public class EmployeeAnnualSalary {
    private int id;
    private String nom;
    private String prenom;
    private int annee;
    private double salaireAnnuel;



}

