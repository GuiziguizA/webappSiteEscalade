package sig.org.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jca.cci.RecordTypeNotSupportedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sig.org.classe.Commentaires;
import sig.org.classe.Region;
import sig.org.classe.SiteEscalade;
import sig.org.classe.Topos;
import sig.org.classe.Utilisateur;
import sig.org.dao.RegionRepository;
import sig.org.dao.ToposRepository;
import sig.org.dao.UtilisateurRepository;
@Service
@Transactional
public class ToposMetier implements Itopos{

	@Autowired
	private ToposRepository toposRepository;
	@Autowired
	private RegionRepository regionRepository;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	
	@Override
	public Topos createTopos(String statut,Long codeRegion,Long codeUtilisateur, String dateDeParuption ,String description , String nom) throws Exception {
		Optional<Region> region = regionRepository.findById(codeRegion);
		if(!region.isPresent()) {
			throw new Exception("Le site n'existe pas");
		}
		
		Optional<Utilisateur> utilisateur = utilisateurRepository.findById(codeUtilisateur);
		if(!utilisateur.isPresent()) {
			throw new Exception("Cet utilisateur n'existe pas");
		}
	
		
		
			Topos  newEntity = new Topos();
			newEntity.setDateDeParuption(dateDeParuption);
           newEntity.setDescription(description);
           newEntity.setNom(nom);
           newEntity.setRegion(region.get());
           newEntity.setStatut(statut);
           newEntity.setUtilisateur(utilisateur.get());
           return newEntity;
	   
	        
	}

	@Override
	public void deleteToposById(Long  codeTopos) throws Exception {
		 Optional<Topos>topos = toposRepository.findById( codeTopos);
         
	        if(topos.isPresent()) 
	        {
	        	toposRepository.deleteById( codeTopos);
	        } else {
	            throw new Exception("No commentaire record exist for given id");
	        }
	    } 	
	
		
	

	@Override
	public Topos  getToposById(Long  codeTopos) throws Exception {
	    Optional<Topos> topos = toposRepository.findById(codeTopos);
        
        if(topos.isPresent()) {
            return topos.get();
        } else {
            throw new RelationNotFoundException("No commentaire record exist for given id");
        }

	}

	@Override
    public List<Topos> getAllTopos()
    {
        List<Topos> toposList = toposRepository.findAll();
         
        if(toposList.size() > 0) {
            return toposList;
        } else {
            return new ArrayList<Topos>();
        }
    }
	
	
	
	
	
	
	public Topos updateStatutTopos(Long codeTopos, String statut) throws Exception {
		  Optional<Topos> topos = toposRepository.findById(codeTopos);
	        
	        if(!topos.isPresent()) {
	        	
	        	throw new  Exception("le Topos existe pas");
	        }
	        	Topos  newEntity = topos.get();
	        	  newEntity.setStatut(statut);
	        	  return newEntity;
	     
		             
		      
	        

	}	
}
