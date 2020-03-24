package sig.org.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sig.org.classe.SiteEscalade;

public interface SiteEscaladeRepository 
extends JpaRepository<SiteEscalade, Long>{
	
	
	@Query("SELECT u FROM SiteEscalade u WHERE  u.codeSiteEscalade=:x")	
SiteEscalade  findByCodeSiteEscalade(@Param("x")Long codeSiteEscalade);


}
