package sig.org.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sig.org.classe.Reservation;
import sig.org.classe.SiteEscalade;
import sig.org.classe.Topos;
import sig.org.classe.Utilisateur;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	
	
	@Query("SELECT u FROM Reservation u WHERE  u.utilisateurP=:u")	
	public List <Reservation>findByUtilisateurP(@Param("u")Utilisateur utilisateurP );
	
	@Query("SELECT u FROM Reservation u WHERE  u.utilisateur=:u")	
	public List <Reservation>findByUtilisateur(@Param("u")Utilisateur utilisateur );
	
	public Optional<Reservation> findByCodeReservation(Long codeReservation);
	
	@Query("SELECT u FROM Reservation u WHERE  (u.utilisateur = :user)"
	+"and ( u.statut = :statut)"
	+"and (u.topos= :topos)"
			)
	public Optional<Reservation> findByCodeUtilisateurAndStatut(@Param("user")Utilisateur utilisateur,@Param("statut")String statut,@Param("topos")Topos topos);
	
	
}
