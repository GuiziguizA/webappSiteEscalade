package sig.org.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sig.org.classe.SiteEscalade;
@Repository
public interface SiteEscaladeRepository extends JpaRepository<SiteEscalade, Long>{
	
	
	@Query("SELECT u FROM SiteEscalade u WHERE  u.codeSiteEscalade=:u")	
	public SiteEscalade  findByCodeSiteEscalade(@Param("u")Long codeSiteEscalade);

	public Optional<SiteEscalade>  findByAdresse(String adresse);
	
	@Query("SELECT u FROM SiteEscalade u WHERE  u=:u")	
	public Optional<SiteEscalade> findBySite(@Param("u")SiteEscalade site);
}
