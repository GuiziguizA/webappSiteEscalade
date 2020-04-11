package sig.org.classe;

import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity

public class Topos {
	
	/**
	 * codeTopos: id Topos
	 * nom : nom du Topos
	 * description : description du topos
	 * dateDeParuption : date de paruption
	 * utilisateur : objet Utilisateur
	 * statut : statut du Topos (reservé/disponible)
	 * region : objet region 
	 */
	
	@Id @GeneratedValue
	private Long codeTopos;
	@NotBlank(message = "le nom est obligatoire")
	private String nom;
	@NotBlank(message = "la description est obligatoire")
	private String description;
	@NotBlank(message = "la date de paruption  est obligatoire")
	private String dateDeParuption;
	
	@ManyToOne
	@JoinColumn(name="CODE_UTILISATEUR")
	private Utilisateur utilisateur;
	
	private String statut;

	@ManyToOne
	@JoinColumn(name="ID_REGION")
	private Region region;
	@OneToMany(mappedBy="topos",fetch=FetchType.LAZY)
	private Collection<Reservation>reservations;
	
	public Topos() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Topos(String nom, String description, String dateDeParuption, Utilisateur utilisateur, String statut,Region region) {
		super();
		this.nom = nom;
		this.description = description;
		this.dateDeParuption = dateDeParuption;
		this.utilisateur = utilisateur;
		this.statut = statut;
		this.region = region;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateDeParuption() {
		return dateDeParuption;
	}
	public void setDateDeParuption(String dateDeParuption) {
		this.dateDeParuption = dateDeParuption;
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
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Long getCodeTopos() {
		return codeTopos;
	}


}
