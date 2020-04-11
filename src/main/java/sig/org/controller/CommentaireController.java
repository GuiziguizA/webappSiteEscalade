package sig.org.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import sig.org.classe.Commentaires;
import sig.org.classe.SiteEscalade;
import sig.org.classe.Utilisateur;
import sig.org.metier.ISiteEscalade;
import sig.org.metier.Icommentaire;
import sig.org.metier.Iutilisateur;

@Controller
public class CommentaireController {
	@Autowired
	private Iutilisateur utilisateurMetier;
	@Autowired
	private ISiteEscalade siteMetier;
	@Autowired
	private Icommentaire commentaireMetier;
	
	

	@GetMapping("/consulterFormulaireCommentaire/{id}")
	public String formulaireCommentaire(Commentaires commentaires ,Model model,@PathVariable("id") long id,Principal principal) {
		 String name = principal.getName();
		 Optional<Utilisateur> user = utilisateurMetier.findByEmail(name);
		 try {
			SiteEscalade siteEscalade = siteMetier.afficherSiteEscalade(id);
			 model.addAttribute("siteEscalade", siteEscalade);
		} catch (RelationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return "formulaireCommentaire";
	}
	
	
	
	@GetMapping("/ajouterCommentaire/{id}")
	public String ajouterUnCommentaire(Commentaires commentaires,  BindingResult result,Model model,Principal principal,@PathVariable("id") Long id) {
		 String name = principal.getName();
		 Optional<Utilisateur> utilisateur = utilisateurMetier.findByEmail(name);
		 model.addAttribute("utilisateur",utilisateur);
		 try {
			SiteEscalade siteEscalade = siteMetier.afficherSiteEscalade(id);
			 model.addAttribute("siteEscalade", siteEscalade);
			try {
				commentaireMetier.createCommentaire(siteEscalade.getCodeSiteEscalade(), utilisateur.get().getCodeUtilisateur(), commentaires.getDescription());
				 List<Commentaires> listCommentaires = commentaireMetier.getSiteAllCommentaire(siteEscalade,id) ;
				  model.addAttribute("listCommentaires", listCommentaires );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return "siteDetails";
	}
	
	
	
	
	
	  @GetMapping("/deleteCommentaire/{id}") 
	  public String deleteCommentaire(Model model, @PathVariable("id") long id ,Commentaires commentaires){
		  
	
		  
		
		  
		  try {
				Commentaires com = commentaireMetier.getCommentaireById(id);
				SiteEscalade siteEscalade = com.getSite();
				model.addAttribute("siteEscalade",siteEscalade);
			commentaireMetier.deleteCommentaireById(id);
			  try {
				  List<Commentaires> listCommentaires = commentaireMetier.getSiteAllCommentaire(siteEscalade, siteEscalade.getCodeSiteEscalade()) ;
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
