package sig.org.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sig.org.classe.Utilisateur;
import sig.org.metier.Iutilisateur;




@Controller
public class UtilisateurController {
	
@Autowired	
private Iutilisateur utilisateurMetier;


@GetMapping("/consulterUser")
public String consulterUtilisateur(Model model) {
	List<Utilisateur> utilisateurList=utilisateurMetier.findAllUtilisateur();
	model.addAttribute("utilisateurList", utilisateurList);
	
    return "utilisateur";
}

	

}
