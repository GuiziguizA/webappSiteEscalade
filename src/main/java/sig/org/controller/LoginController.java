package sig.org.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import sig.org.classe.Roles;
import sig.org.classe.Utilisateur;
import sig.org.dao.RoleRepository;
import sig.org.metier.IRole;
import sig.org.metier.Iutilisateur;
import sig.org.metier.RoleMetier;
@Controller
public class LoginController {
@Autowired
	private Iutilisateur utilisateurMetier;
@Autowired
	private IRole roleMetier;
	
/**
 * afficher le formulaire Utilisateur pour l'incription
 * @param utilisateur
 * @return "formulaireUtilisateur"
 */
	@GetMapping("/consulterFormulaireUtilisateur")
	public String formulaireSite( Utilisateur utilisateur) {
		
		
		
		
		return "formulaireUtilisateur";
	}


/**
 * inscription d'un utilisateur et affiche la page login pour se connecter
 * @param utilisateur
 * @param result
 * @return  "login"
 */
@PostMapping("/ajouterUtilisateur")
public String ajoutSite(@Valid Utilisateur utilisateur, BindingResult result) {
	if (result.hasErrors()) {
		return "formulaireUtilisateur";
	}else {
 
		try {
			Optional<Roles> role=roleMetier.getbyNom("utilisateur");
		utilisateurMetier.createUtilisateur(utilisateur.getNom(),utilisateur.getMail(), utilisateur.getPassword(),role.get());
	
   
		} catch (Exception e) {
			e.printStackTrace();
			 
		}
		return "login";
		
		
	}
}

/**
 * retourne la liste des utilisateur sur la page utilisateurs
 * @param model
 * @return
 */


@GetMapping("/consulterListUtilisateur")
public String consulterListUtilisateur( Model model) {
	
	List<Utilisateur>listUtilisateur=utilisateurMetier.findAllUtilisateur();
	model.addAttribute("listUtilisateur",listUtilisateur);
	
	
	return "utilisateur";
}






}