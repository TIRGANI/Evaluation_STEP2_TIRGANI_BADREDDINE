package com.example.evaluation_step2.service;

import com.example.evaluation_step2.dao.SalaryDAO;
import com.example.evaluation_step2.entity.Salary;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Author: Badreddine Tirgani
 * Date: 21/09/2023
 */
public class SalaryDAOImpl implements SalaryDAO {
    private List<Salary> salaires = new ArrayList<>();
    /**
     * Récupère la liste de tous les salaires.
     *
     * @return Une nouvelle liste contenant tous les salaires.
     */
    @Override
    public List<Salary> getAllSalaires() {
        return new ArrayList<>(salaires);
    }

    /**
     * Récupère un salaire par son identifiant unique.
     *
     * @param id L'identifiant unique du salaire à récupérer.
     * @return Le salaire avec l'ID spécifié, ou null s'il n'est pas trouvé.
     */
    @Override
    public Salary getSalaireById(int id) {
        Optional<Salary> optionalSalaire = salaires.stream()
                .filter(salaire -> salaire.getId() == id)
                .findFirst();
        return optionalSalaire.orElse(null);
    }

    /**
     * Ajoute un nouveau salaire à la liste.
     *
     * @param salaire Le salaire à ajouter.
     */
    @Override
    public void addSalaire(Salary salaire) {
        salaires.add(salaire);
    }

    /**
     * Met à jour un salaire existant dans la liste.
     *
     * @param salaire Le salaire mis à jour.
     */
    @Override
    public void updateSalaire(Salary salaire) {
        salaires.stream()
                .filter(s -> s.getId() == salaire.getId() &&
                        s.getAnnee() == salaire.getAnnee() &&
                        s.getMois() == salaire.getMois())
                .findFirst()
                .ifPresent(s -> s = salaire);
    }

    /**
     * Supprime un salaire par son identifiant unique.
     *
     * @param id L'identifiant unique du salaire à supprimer.
     */
    @Override
    public void deleteSalaire(int id) {
        salaires.removeIf(salaire -> salaire.getId() == id);
    }
}