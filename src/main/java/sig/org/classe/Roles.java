package sig.org.classe;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;


/**
 * 
 * 
 *
 */


@Entity
public class Roles {
	
	
@Id @GeneratedValue
private Long codeRole;
private String nom;
@OneToMany(
	    mappedBy = "roles", 
	    orphanRemoval = true,
	    cascade = CascadeType.ALL)
private Collection<Utilisateur>utilisateurs;




public Roles( String nom) {
	super();
	
	this.nom = nom;
}


public Roles() {
	super();
	// TODO Auto-generated constructor stub
}


public Long getCodeRole() {
	return codeRole;
}


public void setCodeRole(Long codeRole) {
	this.codeRole = codeRole;
}


public String getNom() {
	return nom;
}


public void setNom(String nom) {
	this.nom = nom;
}



	
}
