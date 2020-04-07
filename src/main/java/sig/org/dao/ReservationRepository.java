package sig.org.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sig.org.classe.Reservation;
import sig.org.classe.SiteEscalade;
import sig.org.classe.Utilisateur;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

	
	
	@Query("SELECT u FROM Reservation u WHERE  u.utilisateurP=:u")	
	public List <Reservation>findByUtilisateurP(@Param("u")Utilisateur utilisateurP );
	
	
	public Optional<Reservation> findByCodeReservation(Long codeReservation);
	
	
}
