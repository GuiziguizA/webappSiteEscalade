package sig.org.metier;

import java.awt.print.Pageable;
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
public class SiteEscaladeMetier implements ISiteEscalade{
@Autowired
	public SiteEscaladeRepository siteRepository;


@Override
public SiteEscalade  afficherSiteEscaladeParRegion(Long Region) throws RelationNotFoundException{
		 Optional<SiteEscalade> site = siteRepository.findById(Region);
	        
	        if(site.isPresent()) {
	            return site.get();
	        } else {
	            throw new RelationNotFoundException("No climbing area record exist for given id");
	}
	}
	


public SiteEscalade  afficherSiteEscalade(Long codeSite) {
	 SiteEscalade site = siteRepository.findByCodeSiteEscalade(codeSite);
       
  
	return site;
}



public List<SiteEscalade>getSiteEscalade(){


	List<SiteEscalade> listSite =siteRepository.findAll();
	
	return listSite;
}
}