package sig.org.classe;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Region implements Serializable {
	
	
	/**
	 * codeRegion : id Region
	 * nom : nom de la region
	 * Collection<Topos> : Objet collection reliant la region au topos avec un lien OneToMany
	 * topos : les topos de la region
	 * siteEscalades : les sites d'escalades de la region
	 */
	
	@Id  @GeneratedValue
	private Long codeRegion;
	private String nom;
	@OneToMany(mappedBy="region",fetch=FetchType.LAZY)
	private Collection<Topos> topos ;
	/*
	 * @OneToMany(mappedBy="region",fetch=FetchType.LAZY) private
	 * Collection<SiteEscalade> siteEscalades; 
	 */
	
	
	
	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCodeRegion() {
		return codeRegion;
	}

	public Region(String nom) {
		super();
		this.nom = nom;
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Topos> getTopos() {
		return topos;
	}

	public void setTopos(Collection<Topos> topos) {
		this.topos = topos;
	}
	
	
	
}
