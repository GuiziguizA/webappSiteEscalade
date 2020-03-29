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



	


@Override
public SiteEscalade  createSiteEscalade(SiteEscalade site) throws RelationNotFoundException{

Optional<SiteEscalade>site1=siteRepository.findByAdresse(site.getAdresse());

if(site1.isPresent()) {
	  throw new RelationNotFoundException("le site existe deja");

} else {
	 return  siteRepository.save(site);
}
}



@Override
public SiteEscalade  afficherSiteEscalade(Long codeSite) {
	 SiteEscalade site = siteRepository.findByCodeSiteEscalade(codeSite);
       
  
	return site;
}


@Override
public List<SiteEscalade>getSiteEscalade(){


	List<SiteEscalade> listSite =siteRepository.findAll();
	
	return listSite;
}


public SiteEscalade afficherSiteEscaladeParRegion(Long Region) throws RelationNotFoundException {

			 Optional<SiteEscalade> site = siteRepository.findById(Region);
		        
		        if(site.isPresent()) {
		            return site.get();
		        } else {
		            throw new RelationNotFoundException("No climbing area record exist for given id");
		
		}
}
}