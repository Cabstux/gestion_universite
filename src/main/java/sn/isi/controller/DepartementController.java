package sn.isi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sn.isi.entities.Departement;
import sn.isi.repository.DepartementRepository;

@Controller
@RequestMapping("/departements")
public class DepartementController {

    @Autowired
    private DepartementRepository departementRepository;

    // Afficher la liste des départements
    @GetMapping("/")
    public String listeDepartements(Model model) {
        List<Departement> departements = departementRepository.findAll();
        model.addAttribute("departements", departements);
        return "departements/liste";
    }

    // Formulaire d'ajout
    @GetMapping("/ajouter")
    public String formulaireAjout(Model model) {
        model.addAttribute("departement", new Departement());
        return "departements/ajouter";
    }

    // Traitement de l'ajout
    @PostMapping("/ajouter")
    public String ajouterDepartement(@ModelAttribute Departement departement) {
        departementRepository.save(departement);
        return "redirect:/departements/";
    }

    // Formulaire de modification
    @GetMapping("/modifier/{codedep}")
    public String formulaireModification(@PathVariable String codedep, Model model) {
        Departement departement = departementRepository.findById(codedep)
                .orElseThrow(() -> new RuntimeException("Département non trouvé"));
        model.addAttribute("departement", departement);
        return "departements/modifier";
    }

    // Traitement de la modification
    @PostMapping("/modifier")
    public String modifierDepartement(@ModelAttribute Departement departement) {
        departementRepository.save(departement);
        return "redirect:/departements/";
    }

    // Suppression
    @GetMapping("/supprimer/{codedep}")
    public String supprimerDepartement(@PathVariable String codedep) {
        departementRepository.deleteById(codedep);
        return "redirect:/departements/";
    }

    // Détails d'un département
    @GetMapping("/details/{codedep}")
    public String detailsDepartement(@PathVariable String codedep, Model model) {
        Departement departement = departementRepository.findById(codedep)
                .orElseThrow(() -> new RuntimeException("Département non trouvé"));
        model.addAttribute("departement", departement);
        return "departements/details";
    }
}