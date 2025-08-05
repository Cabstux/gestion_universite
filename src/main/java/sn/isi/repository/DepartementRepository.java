package sn.isi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.isi.entities.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, String> {
    
    // Méthodes personnalisées si nécessaire
    Departement findByNomdep(String nomdep);
    
    boolean existsByCodedep(String codedep);
} 