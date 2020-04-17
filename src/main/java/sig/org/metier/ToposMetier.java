package sig.org.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import sig.org.classe.Topos;
import sig.org.classe.Utilisateur;
import sig.org.dao.ToposRepository;

@Service
@Transactional
public class ToposMetier implements Itopos{

	@Autowired
	private ToposRepository toposRepository;
	
	
	
	/**
	 * Methode creation d'un topos a partir d'un objet Topos dans le repository
	 * @param  topos
	 */
	@Override
	public Topos createTopos(Topos topos) {
		topos.setStatut("disponible");
		toposRepository.save(topos);
		return topos;        
	}

	/**
	 * Méthode permettant de supprimer un topos du repository en fonction de l'id
	 * 
	 * @param codeTopos
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
	 * @param codeTopos
	 * 
	 * @return topos
	 */
	

	@Override
	public Topos  getToposById(Long  codeTopos) throws Exception {
		
	    Optional<Topos> topos = toposRepository.findById(codeTopos);
        
        if(topos.isPresent()) {
        	
            return topos.get();
            
        } else {
        	
            throw new RelationNotFoundException("le topos n'existe pas");
        
        }

	}

	/**
	 * Méthode retournant la liste de tous les topos du repository
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
	 * @param topos
	 * 
	 * @return newEntity
	 */
	
	@Override
	public Topos updateStatutTopos(Topos topos) throws Exception {
	
		Optional<Topos> topos1 = toposRepository.findById(topos.getCodeTopos());
	        
	        if(!topos1.isPresent()) {
	        	
	        	throw new  Exception("le Topos existe pas");
	        	
	        }
       if(topos.getStatut()=="disponible") {
	        	
	        	throw new  Exception("le Topos n'est pas reservé");
	        	
	        }
	        
	        Topos  newEntity = topos1.get();
	        
	         newEntity.setStatut("disponible");
	         toposRepository.save(newEntity);
	        	  
	         return newEntity;
	     
	}	
	
	/**
	 * retourne la liste de topos possedés par l'utilisateur
	 * @param utilisateur
	 * @return toposList
	 */
	@Override
    public List<Topos> getUtilisateurTopos(Utilisateur utilisateur){
		
        List<Topos> toposList = toposRepository.findByUtilisateur(utilisateur);
         
        if(toposList.size() > 0) {
        
        	return toposList;
        
        } else {
        
        	return new ArrayList<Topos>();
        
        }
    
	}
	
	/**
	 * retourne une topos en fonction de son nom
	 * @param nom 
	 * @return  topos.get()
	 */
	@Override
	public Topos getNomTopos (String nom) throws Exception {
		
		Optional<Topos> topos = toposRepository.findByNom(nom);
		
	    if(!topos.isPresent()) {
        	
        	throw new  Exception("le Topos existe pas");
        	
        }
		return topos.get();
		
		
	}
	
	
	/**
	 * retourne un topos en fonction de son code
	 * @param codeTopos
	 * @return topos.get()
	 * 
	 */
	@Override
	public Topos getToposByCodeTopos (Long codeTopos) throws Exception {
		
		Optional<Topos> topos = toposRepository.findById(codeTopos);
		
	    if(!topos.isPresent()) {
        	
        	throw new  Exception("le Topos existe pas");
        	
        }
		return topos.get();
		
		
	}
    
	}
	
	
	

