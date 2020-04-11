package sig.org.classe;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;



@Entity
public class Commentaires implements Serializable{
	
	
	/**
	 * codeCommentaire : id commentaire
	 * Utilisateur : objet Utilisateur
	 * descripton : contenu du commentaire
	 * site : objet SiteEscalade
	 * date : objet Date representant la date de l'ecriture du commentaire
	 */
	
	@Id @GeneratedValue
	private Long codeCommentaire;
	@ManyToOne
	@JoinColumn
	private Utilisateur utilisateur;
	@NotBlank(message = "la description est obligatoire")
	private String description;	
	@ManyToOne
	@JoinColumn
	private SiteEscalade site;
	private Date date;




public Commentaires() {
	super();
	// TODO Auto-generated constructor stub
}






public Commentaires(Utilisateur utilisateur, Date date,String description,SiteEscalade site) {
	super();
	this.utilisateur = utilisateur;
	this.date = date;
	this.site=site;
	this.description=description;
}



public SiteEscalade getSite() {
	return site;
}



public void setSite(SiteEscalade site) {
	this.site = site;
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
