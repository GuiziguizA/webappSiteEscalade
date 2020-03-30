package sig.org.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import sig.org.classe.Topos;
import sig.org.dao.ToposRepository;

@Service
@Transactional
public class ToposMetier implements Itopos{

	@Autowired
	private ToposRepository toposRepository;
	
	
	
	/**
	 * Methode creation d'un topos a partir d'un objet Topos dans le repository
	 */
	@Override
	public Topos createTopos(Topos topos) {
		
		toposRepository.save(topos);
		return topos;        
	}

	/**
	 * Méthode permettant de supprimer un topos du repository en fonction de l'id
	 * 
	 * @param topos : objet topos
	 * 
	 */
	
	@Override
	public void deleteToposById(Long  codeTopos) throws Exception {
		 Optional<Topos>topos = toposRepository.findById( codeTopos);
         
	        if(topos.isPresent()){
	        	
	        	toposRepository.deleteById( codeTopos);
	        	
	        } else {
	        	
	            throw new Exception("No commentaire record exist for given id");
	            
	        }
	    } 	
	
	/**
	 * Méthode permettant de recupérer un topos en fonction d'un id
	 * 
	 * @param topos : objet topos du repository correspondanr à l'id
	 * 
	 * @return topos
	 */
	

	@Override
	public Topos  getToposById(Long  codeTopos) throws Exception {
		
	    Optional<Topos> topos = toposRepository.findById(codeTopos);
        
        if(topos.isPresent()) {
        	
            return topos.get();
            
        } else {
        	
            throw new RelationNotFoundException("No commentaire record exist for given id");
        
        }

	}

	/**
	 * Méthode retournant la liste de tous les topos du repository
	 * 
	 * @param toposList : Liste des topos
	 * 
	 * @return toposList
	 */
	
	@Override
    public List<Topos> getAllTopos(){
		
        List<Topos> toposList = toposRepository.findAll();
         
        if(toposList.size() > 0) {
        
        	return toposList;
        
        } else {
        
        	return new ArrayList<Topos>();
        
        }
    
	}
	
	
	
	/**
	 * Methode permettant de modifier le statut du Topos
	 * 
	 * @param topos : topos correspondant a l'id renseigné
	 * 
	 *@param newEntity : creation d'un nouveau topos
	 *
	 * @return newEntity
	 */
	
	@Override
	public Topos updateStatutTopos(Long codeTopos, String statut) throws Exception {
	
		Optional<Topos> topos = toposRepository.findById(codeTopos);
	        
	        if(!topos.isPresent()) {
	        	
	        	throw new  Exception("le Topos existe pas");
	        	
	        }
	        Topos  newEntity = topos.get();
	        
	         newEntity.setStatut(statut);
	         toposRepository.save(newEntity);
	        	  
	         return newEntity;
	     
	}	
	
}
