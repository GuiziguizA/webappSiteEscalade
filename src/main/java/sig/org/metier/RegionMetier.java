package sig.org.metier;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sig.org.classe.Region;

import sig.org.dao.RegionRepository;

@Service
@Transactional
public class RegionMetier implements Iregion {
	
	private RegionRepository regionRepository;
	
	
	public List<Region> getAllRegion() {
			
		List<Region>listRegion= (List<Region>) regionRepository.findAll();
		
	
		
		return listRegion;
	}

}
