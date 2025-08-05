package sn.isi.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "departements")
public class Departement {
    
    @Id
    @Column(name = "codedep", length = 10)
    private String codedep;
    
    @Column(name = "nomdep", length = 100, nullable = false)
    private String nomdep;
    
    @OneToMany(mappedBy = "departement", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Enseignant> enseignants;
    
    // Constructeurs
    public Departement() {}
    
    public Departement(String codedep, String nomdep) {
        this.codedep = codedep;
        this.nomdep = nomdep;
    }
    
    // Getters et Setters
    public String getCodedep() {
        return codedep;
    }
    
    public void setCodedep(String codedep) {
        this.codedep = codedep;
    }
    
    public String getNomdep() {
        return nomdep;
    }
    
    public void setNomdep(String nomdep) {
        this.nomdep = nomdep;
    }
    
    public List<Enseignant> getEnseignants() {
        return enseignants;
    }
    
    public void setEnseignants(List<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }
    
    @Override
    public String toString() {
        return "Departement{" +
                "codedep='" + codedep + '\'' +
                ", nomdep='" + nomdep + '\'' +
                '}';
    }
} 