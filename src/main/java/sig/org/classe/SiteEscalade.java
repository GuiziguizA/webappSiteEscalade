package sig.org.classe;

import java.util.Collection;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;


/**
 * codeSiteEscalade : id SiteEscalade
 * nom : nom du Site 
 * adresse : l'adresse du site d'escalade 
 * codePostal : code postal du site d'escalade
 * description : description brève du site d'escalade
 * statut : statut du site d'escalade
 * voies : les voies du sites
 * commentaires : les commentaires du site d'escalade
 */



@Entity
public class SiteEscalade {

	@ Id @GeneratedValue 
	private Long codeSiteEscalade;
	
	 @NotBlank(message = "nom est obligatoire")
	private String nom;
	 @NotBlank(message = "l'adresse est obligatoire")
	private String adresse ;
	 @NotBlank(message = "le code postal est obligatoire")
	private String codePostal;
	 @NotBlank(message = "le commentaire est obligatoire")
	private String description;
	 @NotBlank(message = "le statut est obligatoire")
	private String statut;
	/*
	 * @ManyToOne private Region region;
	 */
	@OneToMany(mappedBy="site",fetch=FetchType.LAZY)
	private Collection<Voie> voies;
	
	
	@OneToMany(mappedBy="site",fetch=FetchType.LAZY)
	private Collection<Commentaires> commentaires;
	
	public SiteEscalade() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SiteEscalade(String nom,String adresse, String codePostal, String description,String statut) {
		super();
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.description = description;
		/*
		 * this.region = region;
		 */		this.statut = statut;
		this.nom=nom;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * public Region getRegion() { return region; }
	 * 
	 * 
	 * public void setRegion(Region region) { this.region = region; }
	 */

	public Collection<Voie> getVoies() {
		return voies;
	}


	public void setVoies(Collection<Voie> voies) {
		this.voies = voies;
	}


	


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public Long getCodeSiteEscalade() {
		return codeSiteEscalade;
	}

	
	
	
}
