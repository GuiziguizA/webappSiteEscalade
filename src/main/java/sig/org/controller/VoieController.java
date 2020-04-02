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
import sig.org.classe.SiteEscalade;
import sig.org.classe.Topos;
import sig.org.classe.Utilisateur;
import sig.org.classe.Voie;
import sig.org.metier.ISiteEscalade;
import sig.org.metier.Ivoie;
import sig.org.metier.VoieMetier;

@Controller
public class VoieController {

@Autowired
private Ivoie voieMetier;	
@Autowired
private ISiteEscalade siteMetier;
	
@GetMapping("/consulterVoie")
public String consulterVoie(Model model)	{

	try {
		List<Voie>listVoie = voieMetier.getAllVoie()	;
		model.addAttribute("listVoie",listVoie);
	} catch (Exception e) {
		model.addAttribute(e);
	}

	
return "listVoie"	;
	
}
	


@GetMapping("/consulterFormulaireVoie")
public String consulterVoie(Voie voie,Model model)	{
	
List<SiteEscalade>listSiteEscalade = siteMetier.getSiteEscalade();
model.addAttribute("listSiteEscalade",listSiteEscalade);	
return "formulaireVoie"	;
	
}




@PostMapping("/ajouterVoie")
public String AjouterUneVoie(@Valid Voie voie,Model model, BindingResult result) {
	
	List<SiteEscalade>listSiteEscalade = siteMetier.getSiteEscalade();
	model.addAttribute("listSiteEscalade",listSiteEscalade);	
		
	
	if (result.hasErrors()) {
        return "formulaireVoie";
    }else {
     
 try {
	voieMetier.createVoie(voie);
	 model.addAttribute("voie",voie );
	 return "home";
	   
} catch (Exception e) {
	// TODO Auto-generated catch block
	model.addAttribute("exception",e);
	return "formulaireVoie";
}
	
	}
}

@PostMapping("/listCritère")
public String addCritère(Model model) {
	
	
	
	return null;
	
}



}
	

