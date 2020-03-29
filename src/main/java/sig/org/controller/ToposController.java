package sig.org.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import sig.org.classe.Region;
import sig.org.classe.Topos;
import sig.org.classe.Utilisateur;
import sig.org.metier.Iregion;
import sig.org.metier.Itopos;
import sig.org.metier.Iutilisateur;


@Controller
public class ToposController {
@Autowired
private Itopos toposMetier;	
@Autowired
private Iutilisateur utilisateurMetier;
@Autowired
private Iregion regionMetier;


@GetMapping("/consulterTopos")
public String consulterTopos(Model model) {
	
	List<Topos>listTopos=toposMetier.getAllTopos();
	model.addAttribute("listTopos",listTopos);
	
    return "toposList";
}




@GetMapping("/consulterFormulaireTopos")
public String voirFormulaire(Topos topos,Model model) {
	List<Utilisateur>listUtilisateur = utilisateurMetier.findAllUtilisateur();
	model.addAttribute("listUtilisateur",listUtilisateur);
	
	List<Region> listRegion;
	try {
		listRegion = regionMetier.getAllRegion();
		model.addAttribute("listRegion",listRegion);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
 return "formulaireTopos";
}



@PostMapping("/ajouterTopos")
public String AjouterUnTopos(Model model,@Valid Topos topos, BindingResult result) {
	
	List<Utilisateur>listUtilisateur = utilisateurMetier.findAllUtilisateur();
	model.addAttribute("listUtilisateur",listUtilisateur);
	
	
		List<Region>listRegion = regionMetier.getAllRegion();
		model.addAttribute("listRegion",listRegion);
	
	
	if (result.hasErrors()) {
        return "formulaireTopos";
    }else {
     
 try {
	toposMetier.createTopos(topos);
	 model.addAttribute("topos",topos );
	   
} catch (Exception e) {
	// TODO Auto-generated catch block
	model.addAttribute("exception",e);
}
	return "toposList";
	}
}


}
