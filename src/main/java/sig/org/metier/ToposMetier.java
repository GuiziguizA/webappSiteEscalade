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
	
	
	@Override
	public Topos createTopos(Topos topos) {
		
		toposRepository.save(topos);
         
           return topos;
	   
	        
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
