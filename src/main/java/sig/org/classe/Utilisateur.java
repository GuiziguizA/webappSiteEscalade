package sig.org.classe;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.validation.constraints.NotBlank;


import org.springframework.beans.factory.annotation.Autowired;


@Entity
public class Utilisateur{
	
	/**
	 * codeUtilisateur : id Utilisateur
	 * nom : Pseudo de l'utilisateur
	 * password : Mot de passe utilisateur
	 * mail : Adresse e-mail de l'utilisateur
	 * commentaires : collection de commentaire ecrit par l'utilisateur
	 */
	
	
	
	@Id @GeneratedValue
	private Long codeUtilisateur;
	@NotBlank
	private String nom;
	@NotBlank
	private String password;
	@Column(unique =true )
	@NotBlank
	private String mail;
	@OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)	
	private Collection<Commentaires> commentaires;
	@OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)	
	private Collection<Reservation>reservations;
	
	@OneToMany(mappedBy="utilisateur",fetch=FetchType.LAZY)	
	private Collection<Reservation>reservationsT;
	
	@ManyToOne
	@JoinColumn(name="ID_ROLES")
	private Roles roles;

	
	
	
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Utilisateur( String password,String nom, String mail, Roles roles) {
		super();
		this.nom = nom;
		this.mail = mail;
		this.password=password;
		this.roles=roles;
	
	}

	
	
	
	

	




	public Roles getRoles() {
		return roles;
	}



	public void setRoles(Roles roles) {
		this.roles = roles;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Long getCodeUtilisateur() {
		return codeUtilisateur;
	}

	

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}
	
	



	public Collection<Commentaires> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Collection<Commentaires> commentaires) {
		this.commentaires = commentaires;
	}

}
