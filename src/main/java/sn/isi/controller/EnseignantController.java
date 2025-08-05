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
import org.springframework.web.bind.annotation.RequestParam;

import sn.isi.entities.Departement;
import sn.isi.entities.Enseignant;
import sn.isi.repository.DepartementRepository;
import sn.isi.repository.EnseignantRepository;

@Controller
@RequestMapping("/enseignants")
public class EnseignantController {

    @Autowired
    private EnseignantRepository enseignantRepository;

    @Autowired
    private DepartementRepository departementRepository;

    // Afficher la liste des enseignants
    @GetMapping("/")
    public String listeEnseignants(Model model) {
        List<Enseignant> enseignants = enseignantRepository.findAll();
        model.addAttribute("enseignants", enseignants);
        return "enseignants/liste";
    }

    // Formulaire d'ajout
    @GetMapping("/ajouter")
    public String formulaireAjout(Model model) {
        List<Departement> departements = departementRepository.findAll();
        model.addAttribute("enseignant", new Enseignant());
        model.addAttribute("departements", departements);
        return "enseignants/ajouter";
    }

    // Traitement de l'ajout
    @PostMapping("/ajouter")
    public String ajouterEnseignant(@ModelAttribute Enseignant enseignant,
            @RequestParam String codedep) {
        Departement departement = departementRepository.findById(codedep)
                .orElseThrow(() -> new RuntimeException("Département non trouvé"));
        enseignant.setDepartement(departement);
        enseignantRepository.save(enseignant);
        return "redirect:/enseignants/";
    }

    // Formulaire de modification
    @GetMapping("/modifier/{matr}")
    public String formulaireModification(@PathVariable Integer matr, Model model) {
        Enseignant enseignant = enseignantRepository.findById(matr)
                .orElseThrow(() -> new RuntimeException("Enseignant non trouvé"));
        List<Departement> departements = departementRepository.findAll();
        model.addAttribute("enseignant", enseignant);
        model.addAttribute("departements", departements);
        return "enseignants/modifier";
    }

    // Traitement de la modification
    @PostMapping("/modifier")
    public String modifierEnseignant(@ModelAttribute Enseignant enseignant,
            @RequestParam String codedep) {
        Departement departement = departementRepository.findById(codedep)
                .orElseThrow(() -> new RuntimeException("Département non trouvé"));
        enseignant.setDepartement(departement);
        enseignantRepository.save(enseignant);
        return "redirect:/enseignants/";
    }

    // Suppression
    @GetMapping("/supprimer/{matr}")
    public String supprimerEnseignant(@PathVariable Integer matr) {
        enseignantRepository.deleteById(matr);
        return "redirect:/enseignants/";
    }

    // Détails d'un enseignant
    @GetMapping("/details/{matr}")
    public String detailsEnseignant(@PathVariable Integer matr, Model model) {
        Enseignant enseignant = enseignantRepository.findById(matr)
                .orElseThrow(() -> new RuntimeException("Enseignant non trouvé"));
        model.addAttribute("enseignant", enseignant);
        return "enseignants/details";
    }

    // Recherche par département
    @GetMapping("/departement/{codedep}")
    public String enseignantsParDepartement(@PathVariable String codedep, Model model) {
        Departement departement = departementRepository.findById(codedep)
                .orElseThrow(() -> new RuntimeException("Département non trouvé"));
        List<Enseignant> enseignants = enseignantRepository.findByDepartement(departement);
        model.addAttribute("enseignants", enseignants);
        model.addAttribute("departement", departement);
        return "enseignants/liste";
    }
}