package sig.org.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sig.org.classe.Topos;
import sig.org.classe.Utilisateur;

@Repository
public interface ToposRepository extends JpaRepository<Topos, Long>{
	
	
	
	public List<Topos>findByUtilisateur(Utilisateur utilisateur);
	public List<Topos>findByStatut(String statut);
	
	
	@Query("SELECT u FROM Topos u WHERE  u.nom=:u")	
	public Optional<Topos>findByNom(@Param("u")String nom);
	
}
