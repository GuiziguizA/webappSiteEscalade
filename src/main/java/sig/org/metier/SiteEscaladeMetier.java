package sig.org.metier;


import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sig.org.classe.SiteEscalade;
import sig.org.dao.SiteEscaladeRepository;




@Service
@Transactional
public class SiteEscaladeMetier implements ISiteEscalade{
	
	
	@Autowired
	public SiteEscaladeRepository siteRepository;

	/**
	 * Méthode création d'un objet SiteEscalade
	 * 
	 * @param site1 : site d'escalade correspondant a l'id de l'objet site present dans les paramètre de la méthode
	 * 
	 * @return siteRepository.save(site)
	 */

	@Override
	public SiteEscalade  createSiteEscalade(SiteEscalade site) throws RelationNotFoundException{

		Optional<SiteEscalade>site1=siteRepository.findByAdresse(site.getAdresse());

		if(site1.isPresent()) {
			throw new RelationNotFoundException("le site existe deja");

		} else {
			return  siteRepository.save(site);
		}
	}

	/**
	 * Méthode permettant d'afficher un site d'escalade en fonction d'un id de site d'escalade
	 * 
	 * @param site : objet SiteEscalade correspondant a l'id
	 * 
	 * @return site
	 */

	@Override
	public SiteEscalade  afficherSiteEscalade(Long codeSite) {
		SiteEscalade site = siteRepository.findByCodeSiteEscalade(codeSite);
       
  
		return site;
	}

	/**
	 * Méthode renvoyant la list de tout les sites d'escalade
	 * 
	 * @param listSite : liste de tous les sites
	 * 
	 * @return listSite
	 */
	@Override
	public List<SiteEscalade>getSiteEscalade(){


		List<SiteEscalade> listSite =siteRepository.findAll();
	
		return listSite;
	}

	/**
	 * Methode permettant d'afficher les site d'escalade en fonction d'un id Region
	 * 
	 * @param site 
	 * 
	 * @return site
	 */
	
	
	public SiteEscalade afficherSiteEscaladeParRegion(Long Region) throws RelationNotFoundException {

		Optional<SiteEscalade> site = siteRepository.findById(Region);
		        
		if(site.isPresent()) {
			return site.get();
		} else {
			throw new RelationNotFoundException("No climbing area record exist for given id");
		
		}
	}
}