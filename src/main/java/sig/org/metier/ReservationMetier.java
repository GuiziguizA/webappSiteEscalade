package sig.org.metier;


import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sig.org.classe.Reservation;
import sig.org.classe.Topos;
import sig.org.classe.Utilisateur;
import sig.org.dao.ReservationRepository;
import sig.org.dao.ToposRepository;
@Service
@Transactional
public class ReservationMetier implements IReservation{
	
@Autowired
private ToposRepository toposRepository;
@Autowired
private ReservationRepository reservationRepository;
	
@Override
	public Reservation createReservation(Reservation reservation) throws Exception {
		Topos topos = reservation.getTopos();
		Optional<Topos> topos1=toposRepository.findById(topos.getCodeTopos());
		
		if(topos.getStatut()=="reservé") {
			
			throw new Exception("le topos est indisponible");
			
		}
		
		return reservationRepository.save(reservation);
	}
	
	
	
@Override
	public Reservation getReservationById(Long codeReservation) throws Exception {
		
		Optional<Reservation>reservation= reservationRepository.findByCodeReservation(codeReservation);
		if(!reservation.isPresent()) {
			throw new Exception("La reservation n'existe pas");
		}
		
		return reservation.get();
	}


public void deleteReservation(Reservation reservation) {
	
	reservationRepository.deleteById(reservation.getCodeReservation());
	
}

	
	@Override
	public void updateReservationTopos(Reservation reservation,Topos topos) throws Exception{
	
		
		Optional<Topos> topos1=toposRepository.findById(topos.getCodeTopos());
		Optional<Reservation> reservation1=reservationRepository.findById(reservation.getCodeReservation());
		
		if(topos.getStatut()=="reservé") {
			
			throw new Exception("le topos est indisponible");
			
		}
		if(!reservation1.isPresent()) {
			throw new Exception("la réservation n'existe pas");
		}

		
		
		Topos topos2 = topos1.get();
		topos2.setStatut("reservé");
		Reservation reservation2 = reservation1.get();
		reservation2.setStatut("validé");
		
	
		reservationRepository.save(reservation2);
		
	;
		
		
		
}
	@Override
	public List<Reservation> listReservationUnUtilisateur(Utilisateur utilisateurP) {
		
		List<Reservation>listReservation=reservationRepository.findByUtilisateurP(utilisateurP);
		
		if (listReservation.isEmpty()) {
			 List newList = new ArrayList<Reservation>();
			return newList;
		}else {

			return listReservation;
		}
		
		
		
		
	}
	

}
