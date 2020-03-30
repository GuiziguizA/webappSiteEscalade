package sig.org.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sig.org.classe.SiteEscalade;
@Repository
public interface SiteEscaladeRepository extends JpaRepository<SiteEscalade, Long>{
	
	
	@Query("SELECT u FROM SiteEscalade u WHERE  u.codeSiteEscalade=:x")	
	public SiteEscalade  findByCodeSiteEscalade(@Param("x")Long codeSiteEscalade);

	public Optional<SiteEscalade>  findByAdresse(String adresse);
	
	
}
