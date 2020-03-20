package sig.org.metier;

import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sig.org.classe.SiteEscalade;

import sig.org.dao.SiteEscaladeRepository;




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
	
	
}
