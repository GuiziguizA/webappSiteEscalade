package sig.org.controller;


import java.security.Principal;
import java.util.List;


import javax.management.relation.RelationNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import sig.org.classe.Commentaires;
import sig.org.classe.SiteEscalade;

import sig.org.metier.ISiteEscalade;
import sig.org.metier.Icommentaire;


@Controller
public class CommentaireController {
	
	@Autowired
	private ISiteEscalade siteMetier;
	@Autowired
	private Icommentaire commentaireMetier;
	
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
	public String updateCommentaire(Commentaires commentaires,Model model,@PathVariable("id") long id) {
		
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
	  public String deleteCommentaire(Model model, @PathVariable("id") long id ,Commentaires commentaires){
		  
	
		  
		
		  
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
