package sig.org.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.jca.cci.RecordTypeNotSupportedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javassist.expr.NewArray;
import sig.org.classe.SiteEscalade;
import sig.org.classe.Voie;
import sig.org.dao.SiteEscaladeRepository;
import sig.org.dao.VoieRepository;



@Service
@Transactional
public class VoieMetier implements Ivoie{
@Autowired
	private VoieRepository voieRepository;
@Autowired
private SiteEscaladeRepository siteRepository;
	


	@Override	
	public Voie createVoie(String nom, String cotation , String longueur,Long codeSiteEscalade) throws Exception {
		Optional<SiteEscalade> site = siteRepository.findById(codeSiteEscalade);
		if(!site.isPresent()) {
			throw new Exception("Le site n'existe pas");
		}
		
		
		Optional<Voie> voie =voieRepository.findVoieByNomAndSite(nom, site.get()); 
		 if( voie.isPresent()) { 	
			 throw new Exception("La voie  existe deja");
			}
		 
		 
			Voie  newEntity = new Voie();
			newEntity.setCotation(cotation);
           newEntity.setLongueur(longueur);
           newEntity.setNom(nom);
          newEntity.setSite(site.get());
          
          return voieRepository.save(newEntity);
         
	}

	@Override
	public void deleteVoieById(Long codeVoie) throws Exception {
		 Optional<Voie>voie = voieRepository.findById(codeVoie);
         
	        if(voie.isPresent()) 
	        {
	        	voieRepository.deleteById(codeVoie);
	        } else {
	            throw new Exception("Cette Voie n'existe pas");
	        }
	    } 	
	
		
	

	@Override
	public Voie  getVoieById(Long id) throws RelationNotFoundException {
	    Optional<Voie> voie = voieRepository.findById(id);
        
        if(voie.isPresent()) {
            return voie.get();
        } else {
            throw new RelationNotFoundException("Cette Voie n'existe pas");
        }

	}

	@Override
    public List<Voie> getAllVoie()
    {
        List<Voie> toposList = (List<Voie>) voieRepository.findAll();
         
        if(toposList.size() > 0) {
            return toposList;
        } else {
            return new ArrayList<Voie>();
        }
    }

	
	@Override
	public List<Voie> getVoieCritere(String name, String cotation,String longueur) throws Exception {
		List<Voie> listVoieCritere = voieRepository.findVoieByNomAndCotationAndLongueur(name, cotation, longueur);
		
		if (listVoieCritere.isEmpty()) {
			 throw new Exception("Saisissez au moins un critere de selection");
		}
		
		
		
		
		return listVoieCritere;
	}
	
	
@Override
	public List<Voie> getSiteEscalade(Long codeSiteEscalade)throws Exception{
		Optional<SiteEscalade> site = siteRepository.findById(codeSiteEscalade);
		if(!site.isPresent()) {
			throw new Exception("Le site n'existe pas");
		}
		
	List<Voie> listVoieSite = voieRepository.findBySite(site.get());
		
		return listVoieSite;
	}
	
	
	
	
	
	


}