package sig.org.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sig.org.classe.Region;
@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
	
}
