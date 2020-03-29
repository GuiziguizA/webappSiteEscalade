package sig.org.controller;


import java.util.List;

import javax.management.relation.RelationNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sig.org.classe.Commentaires;
import sig.org.classe.SiteEscalade;
import sig.org.classe.Voie;
import sig.org.metier.ISiteEscalade;
import sig.org.metier.Icommentaire;
import sig.org.metier.Ivoie;
import sig.org.metier.VoieMetier;


@Controller		
public class SiteControlleur {

@Autowired
private ISiteEscalade siteMetier;	
@Autowired
private Ivoie VoieMetier;	
@Autowired
private Icommentaire commentaireMetier;

@GetMapping("/siteForm")
public String formulaireSite( SiteEscalade siteEscalade) {
    return "formulaireSite";
}


@PostMapping("/ajoutSite")
public String ajoutSite(@Valid SiteEscalade siteEscalade, BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "formulaireSite";
    }else {
     
 try {
	siteMetier.createSiteEscalade(siteEscalade);
	 model.addAttribute("sites", siteMetier.getSiteEscalade());
	   
} catch (Exception e) {
	// TODO Auto-generated catch block
	model.addAttribute("exception",e);
}
 return "SiteList";
    }
}



	
@GetMapping("/consulterListSite")
public String consulterListSite(Model model){
		List<SiteEscalade> listSite=siteMetier.getSiteEscalade();
		
		model.addAttribute("listSite", listSite);  
		return "SiteList";
	}
	
	


	
	
	  @GetMapping("/consulterSiteDetails/{id}") 
	  public String consulterSiteDetails(Model model, @PathVariable("id") Long id){
	  
	  SiteEscalade siteEscalade;
	  try { 
		  siteEscalade = siteMetier.afficherSiteEscalade(id);
	  model.addAttribute("siteEscalade", siteEscalade);
	  
	  try {
		List<Voie> listVoie = VoieMetier.getSiteEscalade(id);
		 model.addAttribute("listVoie", listVoie);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		 model.addAttribute("error",e); 
	}
	
	 try {
		List<Commentaires> listCommentaires = commentaireMetier.getSiteAllCommentaire(siteEscalade, id) ;
		model.addAttribute("listCommentaires", listCommentaires );
		
		
	} catch (Exception e) {
		 model.addAttribute("error",e); 
	}
	  
	  
	  
	  } catch (RelationNotFoundException e) { 
		  model.addAttribute("exception",e); 
		  	}
	  
	  
	  
	  return "SiteDetails"; }
	 
		
		
	
	
	
}
