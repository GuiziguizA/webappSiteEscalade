package sig.org.dao;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sig.org.classe.Region;
import sig.org.classe.SiteEscalade;

@Repository
public interface SiteEscaladeRepository extends JpaRepository<SiteEscalade, Long>{
	
	
	@Query("SELECT u FROM SiteEscalade u WHERE  u.codeSiteEscalade=:u")	
	public SiteEscalade  findByCodeSiteEscalade(@Param("u")Long codeSiteEscalade);

	public Optional<SiteEscalade>  findByAdresse(String adresse);
	
	@Query("SELECT u FROM SiteEscalade u WHERE  u=:u")	
	public Optional<SiteEscalade> findBySite(@Param("u")SiteEscalade site);
	
	
	@Query("SELECT c FROM SiteEscalade c WHERE  (:cotationMax is null"+ " or c.cotationMax = :cotationMax)"
	+"and (:longueurMax is null"+ " or c.longueurMax = :longueurMax)"
	+"and (nombreDeVoie is null"+ " or c.nombreDeVoie = :nombreDeVoie)"
	+"and (nombreDeSecteur is null"+ " or c.nombreDeSecteur = :nombreDeSecteur)"
	+"and (region is null"+ " or c.region = :region)"
			)
	public List<SiteEscalade> findSiteByCritère(
			@Param("cotationMax")String cotationMax, 
			@Param("longueurMax")String longueurMax,
			@Param("nombreDeVoie")String nombreDeVoie,
			@Param("nombreDeSecteur")String nombreDeSecteur,
			@Param("region")Region region
			);
	
}
