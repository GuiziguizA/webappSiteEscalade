package sig.org.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sig.org.classe.Commentaires;
import sig.org.classe.SiteEscalade;
import sig.org.classe.Utilisateur;

import sig.org.dao.CommentaireRepository;
import sig.org.dao.SiteEscaladeRepository;
import sig.org.dao.UtilisateurRepository;


@Service
@Transactional
public class CommentaireMetier implements Icommentaire {

	@Autowired
	private CommentaireRepository commentaireRepository;
	@Autowired
	private SiteEscaladeRepository siteEscaladeRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	
	/**
	 * Méthode renvoyant une liste de commentaire en fonction d'un id de site d'escalade
	 * 
	 *  
	 * @param site : site d'escalade correspandant a l'id  
	 * @param commentaireList : liste de commentaire du site d'escalade
	 * @return commentaireList
	 */

	@Override
    public List<Commentaires> getSiteAllCommentaire(Long codeSiteEscalade) throws Exception{
		Optional<SiteEscalade> site = siteEscaladeRepository.findById(codeSiteEscalade);
		if(!site.isPresent()) {
			throw new Exception("Le site n'existe pas");
		}
		List<Commentaires> commentaireList = commentaireRepository.findBySite(site.get());
         
        if(commentaireList.size() > 0) {
            return commentaireList;
        } else {
            return new ArrayList<Commentaires>();
        }
    }
	
	
	
	/**
	 * Méthode renvoyant un commentaire en fonction d'un id commentaire
	 * 
	 * @param commentaire : commentaire correspondant a l'id
	 * @return commentaire
	 */
	
	
	
    @Override
    public Commentaires getCommentaireById(Long codeCommentaire) throws Exception {
        Optional<Commentaires> commentaire = commentaireRepository.findById(codeCommentaire);
         
        if(commentaire.isPresent()) {
            return commentaire.get();
        } else {
            throw new Exception("Le commentaire n'existe pas");
        }
    }
	
    
    
    
    /**
     * Méthode créanr un objet commentaire
     * 
     * @param site : site d'ecalade correspondant à l'id site
     * @param utilisateur : utilisateur correspondant à l'id utilisateur
     * @param comm : commentaire créé
     * @return comm
     */
    
    
	
	@Override
	public Commentaires createCommentaire( Long codeSiteEscalade,String mail,String description)throws Exception { 
		Optional<SiteEscalade> site = siteEscaladeRepository.findById(codeSiteEscalade);
		if(!site.isPresent()) {
			throw new Exception("Le site n'existe pas");
		}
		
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByMail(mail);
		if(!utilisateur.isPresent()) {
			throw new Exception("Cet utilisateur n'existe pas");
		}
	
		 Commentaires comm = new Commentaires();
		 comm.setDate(new Date());
		 comm.setDescription(description);
		 comm.setUtilisateur(utilisateur.get());
		 comm.setSite(site.get());
	  return commentaireRepository.save(comm);        
	        }
	
	
	
	

	  @Override
	  public Commentaires updateCommentaireById(Long codeCommentaire,String description) throws Exception   {
	        Optional<Commentaires>commentaire = commentaireRepository.findById(codeCommentaire);
	         
	        if(commentaire.isPresent()) 
	        {
	        	commentaire.get().setDescription(description);
	        	
	        } else {
	            throw new Exception("Le commentaire n'existe pas");
	        }
	        return commentaireRepository.save(commentaire.get());
	    }
	
	

	
		/**
		 * Methode supprimant un commentaire 
		 * 
		 * @param commentaire : commentaire correspondant a l'id 
		 * 
		 */
	  @Override
	  public void deleteCommentaireById(Long codeCommentaire) throws Exception   {
	        Optional<Commentaires>commentaire = commentaireRepository.findById(codeCommentaire);
	         
	        if(commentaire.isPresent()) 
	        {
	        	commentaireRepository.deleteById(codeCommentaire);
	        } else {
	            throw new Exception("Le commentaire n'existe pas");
	        }
	    }
	
	
}
