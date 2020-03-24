package sig.org.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import sig.org.classe.SiteEscalade;
import sig.org.classe.Voie;

public interface VoieRepository extends CrudRepository<Voie, Long> {
	
	
	@Query("SELECT c FROM Voie c WHERE (:nom is null or c.nom = :nom)and(:site is null or c.site = :site)")
	Optional<Voie> findVoieByNomAndSite(@Param("nom")String nom,@Param("site")SiteEscalade site);
	
	@Query("SELECT c FROM Voie c WHERE (:nom is null or c.nom = :nom) and (:cotation is null"
			  + " or c.cotation = :cotation)"+ "and (:longueur is null"
					  + " or c.longueur = :longueur)")
	ArrayList<Voie> findVoieByNomAndCotationAndLongueur(@Param("nom")String nom,@Param("cotation")String cotation, @Param("longueur")String longueur );
	
	
	Page<Voie> findBySite(Long codeSite,Pageable pageable);
	
}
