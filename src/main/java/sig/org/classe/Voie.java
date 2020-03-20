package sig.org.classe;


import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Voie implements Serializable {
@ Id @GeneratedValue
private Long codeVoie;
	private String nom;
	private String longueur;
	private String cotation;
	@ManyToOne
	@JoinColumn(name="ID_SITE")
	private SiteEscalade site;
	
	
	public Voie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Voie(String nom, String longueur, String cotation, SiteEscalade site) {
		super();
		this.nom = nom;
		this.longueur = longueur;
		this.cotation = cotation;
		this.site = site;
		
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLongueur() {
		return longueur;
	}
	public void setLongueur(String longueur) {
		this.longueur = longueur;
	}
	public String getCotation() {
		return cotation;
	}
	public void setCotation(String cotation) {
		this.cotation = cotation;
	}
	public SiteEscalade getSite() {
		return site;
	}
	public void setSite(SiteEscalade site) {
		this.site = site;
	}
	public Long getCodeVoie() {
		return codeVoie;
	}
	
	
	
	
}
