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
	
	
	/**
	 * Controlleur Get affichant formulaireSite.html
	 * @param siteEscalade
	 * @return formulaireSite.html
	 */
	@GetMapping("/siteForm")
	public String formulaireSite( SiteEscalade siteEscalade) {
		return "formulaireSite";
	}

	/**
	 * Controller Post permettant de recuperer les données d'un formulaire permettant d'ajouter un site d'escalade
	 * @param siteEscalade
	 * @param result
	 * @param model
	 * @return SiteList.html
	 */
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
			return "siteList";
		}
	}



	/**
	 * Controller Get permettant d'afficher SiteList.html 
	 * @param model
	 * @return SiteList.html
	 */
	@GetMapping("/consulterListSite")
	public String consulterListSite(Model model){
			List<SiteEscalade> listSite=siteMetier.getSiteEscalade();
		
			model.addAttribute("listSite", listSite);  
			return "siteList";
		}
	
	

	/**
	 * Méthode affichant SiteDetails.html
	 * @param model
	 * @param id
	 * @return SiteDetails.html
	 */
	
	
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

		  return "siteDetails";
	  }
	 
		
		
	
	
	
}
