package sig.org.classe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Reservation {

@Id  @GeneratedValue
private Long codeReservation;


@ManyToOne
@JoinColumn(name="ID_TOPOS")
private Topos topos;

@ManyToOne
@JoinColumn(name="ID_UTILISATEURPOSSESION")
private Utilisateur utilisateurP;


@ManyToOne
@JoinColumn(name="ID_UTILISATEURRESERVATION")
private Utilisateur utilisateur;

private String statut;

public Reservation() {
	super();
	// TODO Auto-generated constructor stub
}

public Reservation( Topos topos, Utilisateur utilisateur, String statut,Utilisateur utilisateurP) {
	super();

	this.topos = topos;
	this.utilisateur = utilisateur;
	this.statut = statut;
	this.utilisateurP=utilisateurP;
}

public Long getCodeReservation() {
	return codeReservation;
}

public void setCodeReservation(Long codeReservation) {
	this.codeReservation = codeReservation;
}

public Topos getTopos() {
	return topos;
}

public void setTopos(Topos topos) {
	this.topos = topos;
}

public Utilisateur getUtilisateur() {
	return utilisateur;
}

public void setUtilisateur(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}

public String getStatut() {
	return statut;
}

public void setStatut(String statut) {
	this.statut = statut;
}

public Utilisateur getUtilisateurP() {
	return utilisateurP;
}

public void setUtilisateurP(Utilisateur utilisateurT) {
	this.utilisateurP = utilisateurT;
}





	
}
