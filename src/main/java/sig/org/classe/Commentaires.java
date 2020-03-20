package sig.org.classe;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity


public class Commentaires implements Serializable{
	
	@Id @GeneratedValue
	private Long codeCommentaire;
	@ManyToOne
	@JoinColumn(name="CODE_UTILISATEUR")
private Utilisateur utilisateur;
private String description;	
	@ManyToOne
	@JoinColumn(name="ID_SITE")
	private SiteEscalade site;
	private Date date;




public Commentaires() {
	super();
	// TODO Auto-generated constructor stub
}



public Commentaires(Utilisateur utilisateur, Date date,String description) {
	super();
	this.utilisateur = utilisateur;
	this.date = date;
	
}



public Utilisateur getUtilisateur() {
	return utilisateur;
}



public void setUtilisateur(Utilisateur utilisateur) {
	this.utilisateur = utilisateur;
}



public Date getDate() {
	return date;
}



public void setDate(Date date) {
	this.date = date;
}



public String getDescription() {
	return description;
}



public void setDescription(String description) {
	this.description =description;
}



public Long getCodeCommentaire() {
	return codeCommentaire;
}











	

}
