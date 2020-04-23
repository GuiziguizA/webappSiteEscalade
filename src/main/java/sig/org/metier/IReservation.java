package sig.org.metier;

import java.util.List;
import java.util.Optional;

import sig.org.classe.Reservation;
import sig.org.classe.Topos;
import sig.org.classe.Utilisateur;

public interface IReservation {

	public void updateReservationTopos(Reservation reservation, Topos topos) throws Exception;

	public Reservation createReservation(Reservation reservation, Utilisateur utilisateur) throws Exception;

	public	List<Reservation> listReservationUnUtilisateur(Utilisateur utilisateurP);

	public void deleteReservation(Reservation reservation);
	
	public Reservation getReservationById(Long codeReservation) throws Exception ;

	public List<Reservation> listReservationUtilisateurTopos(Utilisateur utilisateur);



	

	

}
