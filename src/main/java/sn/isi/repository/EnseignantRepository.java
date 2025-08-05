package sn.isi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.entities.Enseignant;
import sn.isi.entities.Departement;

import java.util.List;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {
    
    // Méthodes personnalisées
    List<Enseignant> findByDepartement(Departement departement);
    
    List<Enseignant> findByGrade(String grade);
    
    List<Enseignant> findByNomContainingIgnoreCase(String nom);
} 