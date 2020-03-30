package sig.org.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
	
	/**
	 * Méthode de création d'une voie
	 * 
	 * @param site : SiteEscalade du repository correspondant a l'id du site
	 * @param voie : Voie du repository correspondant au nom et au site
	 * @param newEntity : objet Voie créé
	 * 
	 * @return newEntity 
	 */

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

	
	/**
	 * Méthode permettant de supprimer une voie
	 * 
	 * @voie : voie du repository correspondant a l'id
	 * 
	 */
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
	
		
	/**
	 * Methode affichant la Voie correspondant a l'id dans le repository
	 * 
	 * @param voie : voie correspondant a l'id
	 * 
	 * @return voie
	 */

	@Override
	public Voie  getVoieById(Long id) throws RelationNotFoundException {
	    Optional<Voie> voie = voieRepository.findById(id);
        
        if(voie.isPresent()) {
            return voie.get();
        } else {
            throw new RelationNotFoundException("Cette Voie n'existe pas");
        }

	}
	
	/**
	 * Methode affichant la liste de toutes les voies
	 * 
	 * @param voieList : liste de toute les voies du repository
	 * 
	 * @returnvoieList
	 */
	
	@Override
    public List<Voie> getAllVoie() throws Exception{
       List<Voie> voieList = (ArrayList<Voie>) voieRepository.findAll();
         
        if(voieList.isEmpty()) {
        	throw new Exception("error");
    
        }else {
        	 return voieList;
             
		}
       
        
    }

	/**
	 * Méthode retournant une liste de voie en fonction de 3 critère pouvanrt etre null (name, cotation,longueur)
	 * 
	 * @param listVoieCritere : liste des voies en fonction des différents critères
	 * 
	 * @return listVoieCritère
	 */
	@Override
	public ArrayList<Voie> getVoieCritere(String name, String cotation,String longueur) throws Exception {
		ArrayList<Voie> listVoieCritere = voieRepository.findVoieByNomAndCotationAndLongueur(name, cotation, longueur);
		
		if (listVoieCritere.isEmpty()) {
			 throw new Exception("Saisissez au moins un critere de selection");
		}
		
		
		
		
		return listVoieCritere;
	}
	

		/**
		 *Methode retournant la liste des Voies d'un site
		 *
		 * @param site : site correspondant a l'id du site
		 * @param listVoieSite : liste des voies du site 
		 * 
		 * @return listVoieSite
		 */
	@Override
	public List<Voie> getSiteEscalade(Long codeSite)throws Exception{
		Optional<SiteEscalade> site = siteRepository.findById(codeSite);
		if(!site.isPresent()) {
			throw new Exception("Le site n'existe pas");
		}
		
		List<Voie> listVoieSite = voieRepository.findBySite(site);
		
		return listVoieSite;
	}
	
	
	
	
	
	


}