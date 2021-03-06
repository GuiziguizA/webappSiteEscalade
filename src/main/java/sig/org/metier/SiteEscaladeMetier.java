package sig.org.metier;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sig.org.classe.Region;
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
	 * @param site
	 * @return siteRepository.save(site)
	 */

	@Override
	public SiteEscalade  createSiteEscalade(SiteEscalade site) throws RelationNotFoundException{
		
		Optional<SiteEscalade>site1=siteRepository.findByAdresse(site.getAdresse());

		if(site1.isPresent()) {
			throw new RelationNotFoundException("le site existe deja");

		} else {
			site.setStatut("non officiel");
			return  siteRepository.save(site);
		}
	}

	/**
	 * Méthode permettant d'afficher un site d'escalade en fonction d'un id de site d'escalade
	 * 
	 * @param codeSite
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
	 * @param codeRegion
	 * 
	 * @return site
	 */
	
	@Override
	public SiteEscalade afficherSiteEscaladeParRegion(Long codeRegion) throws RelationNotFoundException {

		Optional<SiteEscalade> site = siteRepository.findById(codeRegion);
		        
		if(site.isPresent()) {
			return site.get();
		} else {
			throw new RelationNotFoundException("Il n'y a pas de site dans cette region");
		
		}
	}
	
	
	/**
	 * retourne une liste de sites en fonction de criteres pouvant etre null
	 * @param cotationMax
	 *  @param  longueurMax
	 *  @param nombreDeSecteur
	 *  @param nombreDeVoie
	 *  @param  region
	 *  @return listSiteCritere
	 */
	
	@Override
	public List<SiteEscalade> getSiteEscaladeCritere(String cotationMax,String longueurMax,String nombreDeSecteur,String nombreDeVoie, Region region) throws Exception {
	
 if(cotationMax.equals("")) {
	 cotationMax=null;
 }
 if(longueurMax.equals("")) {
	 longueurMax=null;
 }
 if(nombreDeSecteur.equals("")) {
	 nombreDeSecteur=null;
 }
 if(nombreDeVoie.equals("")) {
	 nombreDeVoie=null;
 }
		List<SiteEscalade> listSiteCritere =siteRepository .findSiteByCritere(cotationMax,  longueurMax, nombreDeVoie, nombreDeSecteur, region);
		
		
		
		
		return listSiteCritere;
	}
	
	
	/**
	 * modifie le statut du site
	 * @param  CodeSite
	 * return siteRepository.save(site.get())
	 */
	@Override
public SiteEscalade modifierStatutSite(Long CodeSite) throws Exception {
	Optional<SiteEscalade> site=siteRepository.findById(CodeSite);
	
	if(site.get().getStatut().equals("non officiel")) {
	site.get().setStatut("Officiel Les amis de l’escalade");

	}else if (site.get().getStatut().equals("Officiel Les amis de l’escalade")){
		site.get().setStatut("non officiel");
		
	}else {
		throw new Exception("probleme au niveau de la condition des statuts"+site.get().getStatut());
	}
		
	
	
	return siteRepository.save(site.get());
	
}
	
	
}