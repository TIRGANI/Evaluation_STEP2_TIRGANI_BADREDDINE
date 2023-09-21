package com.example.evaluation_step2.test;

import com.example.evaluation_step2.service.SalaryDAOImpl;
import com.example.evaluation_step2.dao.SalaryDAO;
import com.example.evaluation_step2.entity.Salary;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Badreddine Tirgani
 * Date: 21/09/2023
 */
public class SalaryTest {

    @Test
    void testGetAllSalaires() {
        SalaryDAO dao = new SalaryDAOImpl();

        List<Salary> salaires = dao.getAllSalaires();
        assertEquals(0, salaires.size());

        dao.addSalaire(new Salary(1, 2021, 10, 5000.0));
        dao.addSalaire(new Salary(2, 2021, 11, 6000.0));

        salaires = dao.getAllSalaires();
        assertEquals(2, salaires.size());
    }

    @Test
    void testGetSalaireById() {
        SalaryDAO dao = new SalaryDAOImpl();

        Salary salaire = new Salary(1, 2021, 10, 5000.0);
        dao.addSalaire(salaire);

        Salary retrievedSalaire = dao.getSalaireById(1);

        assertNotNull(retrievedSalaire);
        assertEquals(salaire, retrievedSalaire);
    }
    @Test
    void testUpdateSalaire() {
        SalaryDAO dao = new SalaryDAOImpl();

        Salary salaire = new Salary(1, 2021, 10, 5000.0);
        dao.addSalaire(salaire);

        salaire.setSalaireMensuel(6000.0);
        dao.updateSalaire(salaire);

        Salary updatedSalaire = dao.getSalaireById(1);

        assertNotNull(updatedSalaire);
        assertEquals(6000.0, updatedSalaire.getSalaireMensuel());
    }

    @Test
    void testDeleteSalaire() {
        SalaryDAO dao = new SalaryDAOImpl();

        Salary salaire = new Salary(1, 2021, 10, 5000.0);
        dao.addSalaire(salaire);

        dao.deleteSalaire(1);

        assertNull(dao.getSalaireById(1));
    }
}