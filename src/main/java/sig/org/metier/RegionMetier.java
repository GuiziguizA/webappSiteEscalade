package sig.org.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sig.org.classe.Region;

import sig.org.dao.RegionRepository;

@Service
@Transactional
public class RegionMetier implements Iregion {
	
	@Autowired
	private RegionRepository regionRepository;
	
	
	/**
	 * Methode renvoyant une liste de toute les regions
	 * 
	 * @param listRegion : list de toute les region
	 * 
	 * @return litRegion
	 */
	
	
	public List<Region> getAllRegion() {
			
		List<Region>listRegion= (List<Region>) regionRepository.findAll();
		
	
		
		return listRegion;
	}

}
