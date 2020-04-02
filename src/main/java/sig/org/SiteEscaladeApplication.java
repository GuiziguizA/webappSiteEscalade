package sig.org;




import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sig.org.classe.Region;

import sig.org.classe.SiteEscalade;
import sig.org.classe.Utilisateur;
import sig.org.classe.Voie;
import sig.org.dao.RegionRepository;

import sig.org.dao.SiteEscaladeRepository;

import sig.org.dao.VoieRepository;

import sig.org.metier.UtilisateurMetier;

import sig.org.classe.Commentaires;

import sig.org.classe.Topos;



import sig.org.dao.CommentaireRepository;

import sig.org.metier.ISiteEscalade;

import sig.org.metier.Iregion;
import sig.org.metier.Itopos;

import sig.org.metier.Ivoie;










@SpringBootApplication
public class SiteEscaladeApplication implements CommandLineRunner {
	
	@Autowired
	private UtilisateurMetier utilisateurMetier;
	@Autowired
	private SiteEscaladeRepository siteEscaladeRepository;
	@Autowired
	private RegionRepository regionRepository;
	@Autowired
	private VoieRepository voieRepository;
	@Autowired
	private ISiteEscalade siteMetier;
	@Autowired
	private CommentaireRepository commentaireRepository;
	@Autowired
	private Itopos toposMetier;
	@Autowired
	private Iregion regionMetier;
	@Autowired
	private Ivoie voieMetier;
	
	
    public static void main(String[] args) {
        SpringApplication.run(SiteEscaladeApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		
	
		Region lyon=regionRepository.save(new Region("lyon"));
		Region r1=regionRepository.save(new Region("r1"));
		Region r2=regionRepository.save(new Region("r2"));
		Region r3=regionRepository.save(new Region("r3"));
		Region r4=regionRepository.save(new Region("r4"));
		SiteEscalade site = new SiteEscalade("nom1", "adresse", "codePostal", "commentaire", "statut");
		SiteEscalade s1 = siteEscaladeRepository.save(new SiteEscalade("les site des trvdsuff","45 rue du facon" ,"65230","Site eclaté au sol","RAS")); 
		SiteEscalade s2 = siteEscaladeRepository.save(new SiteEscalade("les site desvsdvs truff","45 ruevsdv du facon" ,"652vdsv30","Sitvdsve eclaté au sol","RAS")); 
		SiteEscalade s3 = siteEscaladeRepository.save(new SiteEscalade("les sitevsv des truff","45 rue duvdsv facon" ,"652dvs30","Site evdsvclaté au sol","RAS")); 
		SiteEscalade s4 = siteEscaladeRepository.save(new SiteEscalade("les sitvsdve des truff","45 rue du favdsvcon" ,"65vs230","Site evdvsclaté au sol","RAS")); 
		Utilisateur u1=utilisateurMetier.createUtilisateur("u1", "mail1", "pw1");
		Utilisateur u2=utilisateurMetier.createUtilisateur("u2", "mail2", "pw2");
		Utilisateur u3=utilisateurMetier.createUtilisateur("u3", "mail3", "pw3");
		Utilisateur u4=utilisateurMetier.createUtilisateur("u4", "mail4", "pw4");
		Utilisateur admin=utilisateurMetier.createUtilisateur("admin", "admin", "admin");
		
		siteMetier.createSiteEscalade(site);
		voieRepository.save(new Voie("ddd","longueur1","cotation1",s1));
		voieRepository.save(new Voie("ddddd","longueur1","cotation1",s1));
		voieRepository.save(new Voie("dqqqdd","longueur1","cotation1",s1));
		 voieRepository.save(new Voie("dgfdgdd","4d5","cotation1",s1));
		voieRepository.save(new Voie("dgfdgdd","45ggf","cotation1",s1));
		commentaireRepository.save(new Commentaires(u1, new Date(), "description 1",s1));
		commentaireRepository.save(new Commentaires(u1, new Date(), "description 2",s1));
		commentaireRepository.save(new Commentaires(u1, new Date(), "description 3",s1));
		toposMetier.createTopos(new Topos("topos 1", "description 1","Date1",u1,"disponible",lyon));
		toposMetier.createTopos(new Topos("topos 2", "description 1","Date1",u2,"disponible",r1));
		toposMetier.createTopos(new Topos("topos 3", "description 1","Date1",u3,"disponible",r2));
		toposMetier.createTopos(new Topos("topos 4", "description 1","Date1",u4,"disponible",r3));
		toposMetier.createTopos(new Topos("topos 5", "description 1","Date1",u4,"disponible",r4));
		List<Voie>lv1= voieMetier.getAllVoie();
		Voie voie=new Voie("voi6", "longueur6", "cotation7", s3);
		voieMetier.createVoie(voie);
		List<Voie>listVVVVV=voieMetier.getVoieCritere(null, "cotation1","longueur1");
		System.out.println(lv1);
		System.out.println(listVVVVV);
		
		
	}
}

		
		
		
		
		
	


