package sig.org.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import sig.org.classe.CotationClasse;
import sig.org.classe.LongueurClasse;
import sig.org.classe.SiteEscalade;
import sig.org.classe.Voie;
import sig.org.metier.ISiteEscalade;
import sig.org.metier.Ivoie;


@Controller
public class VoieController {

@Autowired
private Ivoie voieMetier;	
@Autowired
private ISiteEscalade siteMetier;
	
@GetMapping("/consulterVoie")
public String consulterVoie(Model model,Voie voie )	{

	
	try {
		List<Voie>listVoie = voieMetier.getAllVoie()	;
		model.addAttribute("listVoie",listVoie);
	} catch (Exception e) {
		model.addAttribute(e);
	}


	
	try {
		List<Voie>listCritere = voieMetier.getVoieCritere( voie.getCotation(), voie.getLongueur());
		model.addAttribute("listCritere", listCritere);
	} catch (Exception e) {
		
		model.addAttribute(e);
	}
	
	
return "listVoie"	;
	
}
	


@GetMapping("/consulterFormulaireVoie")
public String consulterVoie(Voie voie,Model model)	{
	
List<SiteEscalade>listSiteEscalade = siteMetier.getSiteEscalade();
model.addAttribute("listSiteEscalade",listSiteEscalade);	

CotationClasse cotation1=new CotationClasse();
List<String>listCotations=cotation1.listCotation();
model.addAttribute("listCotations",listCotations);
LongueurClasse lg = new LongueurClasse();
List<String>listLongueurs=lg.listLongueur();
model.addAttribute("listLongueurs",listLongueurs);

return "formulaireVoie"	;
	
}




@PostMapping("/ajouterVoie")
public String AjouterUneVoie(@Valid Voie voie,Model model,String cotation,String longueur, BindingResult result) {
	
	
	List<SiteEscalade>listSiteEscalade = siteMetier.getSiteEscalade();
	model.addAttribute("listSiteEscalade",listSiteEscalade);	
	
		
		
		 
	
	
	
	
	if (result.hasErrors()) {
        return "formulaireVoie";
    }else {
     
 try {
	voieMetier.createVoie(voie);
	 model.addAttribute("voie",voie );
	 return "listVoie";
	   
} catch (Exception e) {
	// TODO Auto-generated catch block
	model.addAttribute("exception",e);
	return "formulaireVoie";
}
	
	}
}


	/*
	 * @PostMapping("/critereListVoie") public String afficherListCritere(Model
	 * model,String cotation,String longueur ,SiteEscalade site) {
	 * 
	 * try { List<Voie>listCritere = voieMetier.getVoieCritere(site, cotation,
	 * longueur); model.addAttribute("listCritere", listCritere); } catch (Exception
	 * e) {
	 * 
	 * model.addAttribute(e); }
	 * 
	 * return "listVoie";
	 * 
	 * }
	 * 
	 */

}
	

