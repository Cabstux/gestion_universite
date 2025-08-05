package sn.isi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControleur {

  // url Appli web Sprint au démarrage : http://localhost:8080/
  // le / route de base
  @GetMapping("/")
  public String bienvenue() {
    return "index";
  }

  @GetMapping("/accueil")
  public String accueil() {
    return "accueil";
  }
}
