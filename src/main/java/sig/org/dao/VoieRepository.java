package sig.org.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sig.org.classe.SiteEscalade;
import sig.org.classe.Voie;
@Repository
public interface VoieRepository extends JpaRepository<Voie, Long> {
	
	
	@Query("SELECT c FROM Voie c WHERE (:nom is null or c.nom = :nom)and(:site is null or c.site = :site)")
	public Optional<Voie> findVoieByNomAndSite(@Param("nom")String nom,@Param("site")SiteEscalade site);
	
	@Query("SELECT c FROM Voie c WHERE  (:cotation is null"+ " or c.cotation = :cotation)"+ "and (:longueur is null"+ " or c.longueur = :longueur)")
	public ArrayList<Voie> findVoieBySiteAndCotationAndLongueur(@Param("cotation")String cotation, @Param("longueur")String longueur );
	
	
	public List<Voie> findBySite(Optional<SiteEscalade> site);
	

	
	
}
