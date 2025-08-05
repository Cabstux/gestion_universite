# Gestion Université - Application Spring Boot

## Description

Application web développée avec Spring Boot pour la gestion des départements et enseignants d'une université. Cette application permet d'effectuer toutes les opérations CRUD (Create, Read, Update, Delete) sur les modules Département et Enseignant.

## Fonctionnalités

### Gestion des Départements
- ✅ Créer un nouveau département
- ✅ Lister tous les départements
- ✅ Modifier un département existant
- ✅ Supprimer un département
- ✅ Voir les détails d'un département
- ✅ Afficher le nombre d'enseignants par département

### Gestion des Enseignants
- ✅ Ajouter un nouvel enseignant
- ✅ Lister tous les enseignants
- ✅ Modifier un enseignant existant
- ✅ Supprimer un enseignant
- ✅ Voir les détails d'un enseignant
- ✅ Filtrer les enseignants par département

## Technologies Utilisées

- **Backend :** Spring Boot 3.5.0
- **Base de données :** MySQL
- **ORM :** Spring Data JPA / Hibernate
- **Frontend :** Thymeleaf + Bootstrap 5
- **Java :** Version 21

## Structure de la Base de Données

### Table `departements`
- `codedep` (String, PK) : Code unique du département
- `nomdep` (String) : Nom du département

### Table `enseignants`
- `matr` (Integer, PK, Auto-increment) : Matricule de l'enseignant
- `nom` (String) : Nom de l'enseignant
- `prenom` (String) : Prénom de l'enseignant
- `grade` (String) : Grade de l'enseignant
- `codedep` (FK) : Référence vers le département

## Installation et Configuration

### Prérequis
- Java 21 ou supérieur
- MySQL 8.0 ou supérieur
- Maven 3.6 ou supérieur

### Configuration de la Base de Données

1. Créez une base de données MySQL nommée `universite`
2. Modifiez le fichier `src/main/resources/application.properties` selon votre configuration :

```properties
spring.datasource.url=jdbc:mysql://localhost:8889/universite?createDatabaseIfNotExist=true
spring.datasource.username=votre_username
spring.datasource.password=votre_password
```

### Lancement de l'Application

1. Clonez le projet
2. Naviguez vers le répertoire du projet
3. Exécutez la commande :
```bash
mvn spring-boot:run
```

4. Accédez à l'application via : `http://localhost:2025`

## Utilisation

### Page d'Accueil
- Interface moderne avec navigation intuitive
- Accès rapide aux modules Départements et Enseignants

### Gestion des Départements
- **URL :** `http://localhost:2025/departements/`
- Ajouter un département : `http://localhost:2025/departements/ajouter`
- Modifier un département : `http://localhost:2025/departements/modifier/{codedep}`
- Détails d'un département : `http://localhost:2025/departements/details/{codedep}`

### Gestion des Enseignants
- **URL :** `http://localhost:2025/enseignants/`
- Ajouter un enseignant : `http://localhost:2025/enseignants/ajouter`
- Modifier un enseignant : `http://localhost:2025/enseignants/modifier/{matr}`
- Détails d'un enseignant : `http://localhost:2025/enseignants/details/{matr}`
- Enseignants par département : `http://localhost:2025/enseignants/departement/{codedep}`

## Fonctionnalités Avancées

### Interface Utilisateur
- Design responsive avec Bootstrap 5
- Icônes Font Awesome pour une meilleure UX
- Navigation intuitive entre les modules
- Messages de confirmation pour les suppressions
- Validation des formulaires côté client et serveur

### Relations entre Entités
- Un département peut avoir plusieurs enseignants (OneToMany)
- Un enseignant appartient à un seul département (ManyToOne)
- Intégrité référentielle maintenue

### Recherche et Filtrage
- Affichage des enseignants par département
- Comptage automatique du nombre d'enseignants par département

## Auteur
Cheikh Ahmadou Bamba Sene
Développé dans le cadre du Exam final - Classe M1GL - ISI

