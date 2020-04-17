package sig.org.controller;


import java.security.Principal;
import java.util.List;


import javax.management.relation.RelationNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import sig.org.classe.Commentaires;
import sig.org.classe.SiteEscalade;
import sig.org.classe.Utilisateur;
import sig.org.metier.ISiteEscalade;
import sig.org.metier.Icommentaire;
import sig.org.metier.Iutilisateur;


@Controller
public class CommentaireController {
	
	@Autowired
	private ISiteEscalade siteMetier;
	@Autowired
	private Icommentaire commentaireMetier;
	@Autowired
	private Iutilisateur utilisateurMetier;
	
	
	private static Logger LOG = LoggerFactory.getLogger(CommentaireController.class);
	/**
	 * controller affichant formulaire commentaire
	 * @param commentaires
	 * @param id_commentaires
	 * @param model
	 * @return "siteDetails"
	 */
	@Secured(value= {"ROLE_admin","ROLE_membre"})
	@GetMapping("/consulterFormulaireCommentaire/{id}")
	public String formulaireCommentaire(Commentaires commentaires ,@PathVariable("id") long id,Model model) {
		try {
			Commentaires com = commentaireMetier.getCommentaireById(id);
			model.addAttribute("com", com);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	return "formulaireCommentaire";
	}
	
	
	/**
	 * controller modifiant le commentaire et affichant siteDetails
	 * @param commentaires
	 * @param model
	 * @param id_commentaires
	 * @return "siteDetails"
	 */
	@Secured(value= {"ROLE_admin","ROLE_membre"})
	@GetMapping("/updateCommentaire/{id}")
	public String updateCommentaire(Commentaires commentaires,Model model,@PathVariable("id") long id,Principal principal) {
		  String name = principal.getName();
		  Utilisateur user;
		  LOG.info("update Commentaire ");
	try {
	
		user = utilisateurMetier.findByEmail(name);
		 String role=user.getRoles().getNom();
		 model.addAttribute("role",role	);
		 
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("probleme");
		
	}
		 
		try {
			commentaireMetier.updateCommentaireById(id, commentaires.getDescription());
			Commentaires com = commentaireMetier.getCommentaireById(id);
			SiteEscalade siteEscalade = com.getSite();
			model.addAttribute("siteEscalade",siteEscalade);
			try {
				  List<Commentaires> listCommentaires = commentaireMetier.getSiteAllCommentaire( siteEscalade.getCodeSiteEscalade()) ;
				  model.addAttribute("listCommentaires", listCommentaires );
		
		
			  } catch (Exception e) {
					e.printStackTrace();
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		return "siteDetails";
		
	}
	
	
	
	/**
	 * controller ajoutant un commentaire et affichant siteDetails
	 * @param commentaires
	 * @param result
	 * @param model
	 * @param principal
	 * @param id_site
	 * @return "siteDetails"
	 */
	
	
	@GetMapping("/ajouterCommentaire/{id}")
	public String ajouterUnCommentaire(Commentaires commentaires,  BindingResult result,Model model,Principal principal , @PathVariable("id") long id ) {
		  String name = principal.getName();
		  Utilisateur user;
		  LOG.info("create Commentaire ");
	try {
	
		user = utilisateurMetier.findByEmail(name);
		 String role=user.getRoles().getNom();
		 model.addAttribute("role",role	);
		 
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("probleme");
		
	}
		 
		 try {
			
			try {
				commentaireMetier.createCommentaire(id,name , commentaires.getDescription());
				 List<Commentaires> listCommentaires = commentaireMetier.getSiteAllCommentaire( id) ;
				  model.addAttribute("listCommentaires", listCommentaires );
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 
		 try {
			SiteEscalade siteEscalade = siteMetier.afficherSiteEscalade(id);
			model.addAttribute("siteEscalade",siteEscalade);
		} catch (RelationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		return "siteDetails";
	}
	
	
	/**
	 * controller supprimant un commentaire et affichant siteDetails
	 * @param model
	 * @param id_commentaires
	 * @param commentaires
	 * @return "siteDetails"
	 */
	
	@Secured(value= {"ROLE_admin","ROLE_membre"})
	  @GetMapping("/deleteCommentaire/{id}") 
	  public String deleteCommentaire(Model model, @PathVariable("id") long id ,Commentaires commentaires,Principal principal){
		  
		  LOG.info("delete Commentaire ");
		  String name = principal.getName();
		  Utilisateur user;
	try {
	
		user = utilisateurMetier.findByEmail(name);
		 String role=user.getRoles().getNom();
		 model.addAttribute("role",role	);
		 
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("probleme");
		
	}
		
		  
		  try {
				Commentaires com = commentaireMetier.getCommentaireById(id);
				SiteEscalade siteEscalade = com.getSite();
				model.addAttribute("siteEscalade",siteEscalade);
			commentaireMetier.deleteCommentaireById(id);
			  try {
				  List<Commentaires> listCommentaires = commentaireMetier.getSiteAllCommentaire( siteEscalade.getCodeSiteEscalade()) ;
				  model.addAttribute("listCommentaires", listCommentaires );
		
		
			  } catch (Exception e) {
					e.printStackTrace();
			  }
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	  
		  
		  
		
		  return "siteDetails";
	  }		
}
