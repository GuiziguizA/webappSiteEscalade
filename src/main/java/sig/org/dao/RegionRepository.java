package sig.org.dao;



import org.springframework.data.jpa.repository.JpaRepository;


import sig.org.classe.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
	
}
