package sig.org.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.RecordTypeNotSupportedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sig.org.classe.Commentaires;
import sig.org.classe.SiteEscalade;
import sig.org.classe.Utilisateur;
import sig.org.classe.Voie;
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
	
	
	

	@Override
    public List<Commentaires> getSiteAllCommentaire(SiteEscalade siteEscalade,Long codeSiteEscalade) throws Exception{
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
	
	
	
	
	
	
	
    @Override
    public Commentaires getCommentaireById(Long codeCommentaire) throws Exception {
        Optional<Commentaires> commentaire = commentaireRepository.findById(codeCommentaire);
         
        if(commentaire.isPresent()) {
            return commentaire.get();
        } else {
            throw new Exception("Le commentaire n'existe pas");
        }
    }
	
    
    
    
    
    
    
	
	@Override
	public Commentaires createCommentaire( Long codeSiteEscalade,Long codeUtilisateur,String description)throws Exception { 
		Optional<SiteEscalade> site = siteEscaladeRepository.findById(codeSiteEscalade);
		if(!site.isPresent()) {
			throw new Exception("Le site n'existe pas");
		}
		
		Optional<Utilisateur> utilisateur = utilisateurRepository.findById(codeUtilisateur);
		if(!utilisateur.isPresent()) {
			throw new Exception("Cet utilisateur n'existe pas");
		}
	
		 Commentaires comm = new Commentaires();
		 comm.setDate(new Date());
		 comm.setDescription(description);
		 comm.setUtilisateur(utilisateur.get());
		 comm.setUtilisateur(utilisateur.get());
	  return commentaireRepository.save(comm);        
	        }
	
	
	
	
	
	
	
	
	

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
