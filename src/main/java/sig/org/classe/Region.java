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
	@Id  @GeneratedValue
	private Long codeRegion;
	private String nom;
	@OneToMany(mappedBy="region",fetch=FetchType.LAZY)
	private Collection<Topos> topos ;
	@OneToMany(mappedBy="region",fetch=FetchType.LAZY)
private Collection<SiteEscalade> siteEscalade;
	public Region() {
		super();
		// TODO Auto-generated constructor stub
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
