package sn.isi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "enseignants")
public class Enseignant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matr")
    private Integer matr;
    
    @Column(name = "nom", length = 50, nullable = false)
    private String nom;
    
    @Column(name = "prenom", length = 50, nullable = false)
    private String prenom;
    
    @Column(name = "grade", length = 30, nullable = false)
    private String grade;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codedep", nullable = false)
    private Departement departement;
    
    // Constructeurs
    public Enseignant() {}
    
    public Enseignant(String nom, String prenom, String grade, Departement departement) {
        this.nom = nom;
        this.prenom = prenom;
        this.grade = grade;
        this.departement = departement;
    }
    
    // Getters et Setters
    public Integer getMatr() {
        return matr;
    }
    
    public void setMatr(Integer matr) {
        this.matr = matr;
    }
    
    public String getNom() {
        return nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public String getGrade() {
        return grade;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    public Departement getDepartement() {
        return departement;
    }
    
    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
    
    @Override
    public String toString() {
        return "Enseignant{" +
                "matr=" + matr +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", grade='" + grade + '\'' +
                ", departement=" + (departement != null ? departement.getCodedep() : "null") +
                '}';
    }
} 