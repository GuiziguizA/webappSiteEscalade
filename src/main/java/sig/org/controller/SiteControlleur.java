package sig.org.controller;


import java.security.Principal;
import java.util.List;

import javax.management.relation.RelationNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sig.org.classe.Commentaires;
import sig.org.classe.CotationClasse;
import sig.org.classe.LongueurClasse;
import sig.org.classe.NombreDeSecteurClasse;
import sig.org.classe.NombreDeVoieClasse;
import sig.org.classe.Region;
import sig.org.classe.SiteEscalade;
import sig.org.classe.Utilisateur;
import sig.org.dao.UtilisateurRepository;
import sig.org.enumeration.Cotation;
import sig.org.enumeration.Longueur;
import sig.org.enumeration.NombreSecteur;
import sig.org.enumeration.NombreVoie;
import sig.org.metier.ISiteEscalade;
import sig.org.metier.Icommentaire;
import sig.org.metier.Iregion;
import sig.org.metier.Iutilisateur;




@Controller		
public class SiteControlleur {

	@Autowired
	private ISiteEscalade siteMetier;	

	@Autowired
	private Icommentaire commentaireMetier;
	@Autowired
	private Iregion regionMetier;
	private Iutilisateur utilisateurMetier;
	/**
	 * Controlleur Get affichant formulaireSite.html
	 * @param siteEscalade
	 * @return"formulaireSite"
	 */
	@GetMapping("/siteForm")
	public String formulaireSite( SiteEscalade siteEscalade,Model model) {
		
		List<SiteEscalade> listSite=siteMetier.getSiteEscalade();
		
		LongueurClasse lg = new LongueurClasse();
		List<Longueur>listLongueurs=lg.listLongueur();
		model.addAttribute("listLongueurs",listLongueurs);
		List<SiteEscalade>listSiteEscalade = siteMetier.getSiteEscalade();
		model.addAttribute("listSiteEscalade",listSiteEscalade);	
		NombreDeSecteurClasse nbreSecteur=new NombreDeSecteurClasse();
		List<NombreSecteur>listNombreSecteur=nbreSecteur.listNombreSecteur();
		model.addAttribute("listnbreSecteur", listNombreSecteur);
		NombreDeVoieClasse  nbreVoie=new NombreDeVoieClasse();
		List<NombreVoie>listNombreVoie=nbreVoie.listNombreSecteur();
		model.addAttribute("listnbreVoies",listNombreVoie);
		CotationClasse cotation=new CotationClasse();
		List<Cotation>listCotation=cotation.listCotation();
		model.addAttribute("listCotation",listCotation);
		List<Region>listRegion=regionMetier.getAllRegion();
		model.addAttribute("listRegion",listRegion);
		
		
		
		model.addAttribute("listSite", listSite);  
		return "formulaireSite";
	}

	/**
	 * Controller Post permettant de recuperer les données d'un formulaire permettant d'ajouter un site d'escalade
	 * @param siteEscalade
	 * @param result
	 * @param model
	 * @return "formulaireSite"
	 */
	@PostMapping("/ajoutSite")
	public String ajoutSite(@Valid SiteEscalade siteEscalade, BindingResult result, Model model) {
		
		LongueurClasse lg = new LongueurClasse();
		List<Longueur>listLongueurs=lg.listLongueur();
		model.addAttribute("listLongueurs",listLongueurs);
		List<SiteEscalade>listSiteEscalade = siteMetier.getSiteEscalade();
		model.addAttribute("listSiteEscalade",listSiteEscalade);	
		NombreDeSecteurClasse nbreSecteur=new NombreDeSecteurClasse();
		List<NombreSecteur>listNombreSecteur=nbreSecteur.listNombreSecteur();
		model.addAttribute("listnbreSecteur", listNombreSecteur);
		NombreDeVoieClasse  nbreVoie=new NombreDeVoieClasse();
		List<NombreVoie>listNombreVoie=nbreVoie.listNombreSecteur();
		model.addAttribute("listnbreVoies",listNombreVoie);
		CotationClasse cotation=new CotationClasse();
		List<Cotation>listCotation=cotation.listCotation();
		model.addAttribute("listCotation",listCotation);
		List<SiteEscalade>listSite=siteMetier.getSiteEscalade();
		model.addAttribute("listSite",listSite);  
		List<Region>listRegion=regionMetier.getAllRegion();
		model.addAttribute("listRegion",listRegion);
		
		if (result.hasErrors()) {
			return "formulaireSite";
		}else {
     
			try {
				siteMetier.createSiteEscalade(siteEscalade);
				model.addAttribute("sites", siteMetier.getSiteEscalade());
	   
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<SiteEscalade> listSite1=siteMetier.getSiteEscalade();
			
			model.addAttribute("listSiteCritere", listSite1);  
			
		
		
			return "siteList";
		}
	}



	/**
	 * Controller Get permettant d'afficher SiteList.html 
	 * @param model
	 * @return "siteList"
	 */
	@GetMapping("/consulterListSite")
	public String consulterListSite(Model model,SiteEscalade siteEscalade){
		
		
		LongueurClasse lg = new LongueurClasse();
		List<Longueur>listLongueurs=lg.listLongueur();
		model.addAttribute("listLongueurs",listLongueurs);
		List<SiteEscalade>listSiteEscalade = siteMetier.getSiteEscalade();
		model.addAttribute("listSiteEscalade",listSiteEscalade);	
		NombreDeSecteurClasse nbreSecteur=new NombreDeSecteurClasse();
		List<NombreSecteur>listNombreSecteur=nbreSecteur.listNombreSecteur();
		model.addAttribute("listnbreSecteur", listNombreSecteur);
		NombreDeVoieClasse  nbreVoie=new NombreDeVoieClasse();
		List<NombreVoie>listNombreVoie=nbreVoie.listNombreSecteur();
		model.addAttribute("listnbreVoies",listNombreVoie);
		CotationClasse cotation=new CotationClasse();
		List<Cotation>listCotation=cotation.listCotation();
		model.addAttribute("listCotation",listCotation);
		List<Region>listRegion=regionMetier.getAllRegion();
		model.addAttribute("listRegion",listRegion);
			List<SiteEscalade> listSite=siteMetier.getSiteEscalade();
			model.addAttribute("listSiteCritere", listSite);  
			return "siteList";
		}
	
	/**
	 * Renvoie listSite avec la liste des sites en fonction de la selection des différent critere de la fonction getSiteEscaladeCritere
	 * @param model
	 * @param siteEscalade
	 * @return "siteList"
	 */
	
	@PostMapping("/consulterSiteCritere")
	public String consulterSiteCritere(Model model , SiteEscalade siteEscalade) {
		
		LongueurClasse lg = new LongueurClasse();
		List<Longueur>listLongueurs=lg.listLongueur();
		model.addAttribute("listLongueurs",listLongueurs);
		List<SiteEscalade>listSiteEscalade = siteMetier.getSiteEscalade();
		model.addAttribute("listSiteEscalade",listSiteEscalade);	
		NombreDeSecteurClasse nbreSecteur=new NombreDeSecteurClasse();
		List<NombreSecteur>listNombreSecteur=nbreSecteur.listNombreSecteur();
		model.addAttribute("listnbreSecteur", listNombreSecteur);
		NombreDeVoieClasse  nbreVoie=new NombreDeVoieClasse();
		List<NombreVoie>listNombreVoie=nbreVoie.listNombreSecteur();
		model.addAttribute("listnbreVoies",listNombreVoie);
		CotationClasse cotation=new CotationClasse();
		List<Cotation>listCotation=cotation.listCotation();
		model.addAttribute("listCotation",listCotation);
		List<Region>listRegion=regionMetier.getAllRegion();
		model.addAttribute("listRegion",listRegion);
		
		
		try {
			List<SiteEscalade> listSite=siteMetier.getSiteEscaladeCritere(siteEscalade.getCotationMax(),  siteEscalade.getLongueurMax(), siteEscalade.getNombreDeSecteur(),  siteEscalade.getNombreDeVoie(),  siteEscalade.getRegion());
			model.addAttribute("listSiteCritere", listSite);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "siteList";
	}
	

	/**
	 * Méthode affichant SiteDetails.html
	 * @param model
	 * @param id_site
	 * @return "siteDetails"
	 */
	
	
	  @GetMapping("/consulterSiteDetails/{id}") 
	  public String consulterSiteDetails(Model model, @PathVariable("id") Long id,Commentaires commentaire,Principal principal){
	  try {
		Utilisateur user = utilisateurMetier.getByNom(principal.getName());
		String role=user.getRole().getNom();
		model.addAttribute("role",role );
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		  SiteEscalade siteEscalade;
		  try { 
			  siteEscalade = siteMetier.afficherSiteEscalade(id);
			  model.addAttribute("siteEscalade", siteEscalade);
	  
			
	
			  try {
				  List<Commentaires> listCommentaires = commentaireMetier.getSiteAllCommentaire(id) ;
				  model.addAttribute("listCommentaires", listCommentaires );
		
		
			  } catch (Exception e) {
				  model.addAttribute("error",e); 
			  }
	  
	  
	  
		  } catch (RelationNotFoundException e) { 
			  model.addAttribute("exception",e); 
		  		}

		  return "siteDetails";
	  }
	  
	  
	  
	  /**
	   * Modifie le statut du siteEscalade et affiche siteDetails
	   * @param model
	   * @param id
	   * @param commentaire
	   * @param principal
	   * @return "siteDetails"
	   */
	  @Secured(value= {"ROLE_admin","ROLE_membre"})
	  @GetMapping("/modifierStatut/{id}") 
	public String modifierStatutSite(Model model,@PathVariable("id") long id,Commentaires commentaire,Principal principal) {
		  SiteEscalade siteEscalade;
		try {
			siteEscalade = siteMetier.afficherSiteEscalade(id);
		
		} catch (RelationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			siteMetier.modifierStatutSite(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			siteEscalade = siteMetier.afficherSiteEscalade(id);
			model.addAttribute("siteEscalade",siteEscalade);

			Utilisateur user = utilisateurMetier.getByNom(principal.getName());
			String role=user.getRole().getNom();
			model.addAttribute("role",role);
			
			  List<Commentaires> listCommentaires = commentaireMetier.getSiteAllCommentaire(id) ;
			  model.addAttribute("listCommentaires", listCommentaires );
	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		
		
		return "siteDetails";
		
	}
	
	
}
