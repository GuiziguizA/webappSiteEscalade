package sig.org;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import sig.org.classe.Region;
import sig.org.classe.Reservation;
import sig.org.classe.Roles;
import sig.org.classe.SiteEscalade;
import sig.org.classe.Utilisateur;

import sig.org.dao.RegionRepository;

import sig.org.dao.SiteEscaladeRepository;
import sig.org.dao.UtilisateurRepository;
import sig.org.enumeration.Cotation;
import sig.org.enumeration.Longueur;
import sig.org.metier.UtilisateurMetier;

import sig.org.classe.Commentaires;
import sig.org.classe.CotationClasse;
import sig.org.classe.LongueurClasse;
import sig.org.classe.Topos;



import sig.org.dao.CommentaireRepository;
import sig.org.metier.CustomUserDetailService;
import sig.org.metier.IReservation;
import sig.org.metier.IRole;
import sig.org.metier.ISiteEscalade;
import sig.org.metier.Icommentaire;
import sig.org.metier.Iregion;
import sig.org.metier.Itopos;












@SpringBootApplication
public class SiteEscaladeApplication implements CommandLineRunner {
	
	@Autowired
	private UtilisateurMetier utilisateurMetier;
	@Autowired
	private SiteEscaladeRepository siteEscaladeRepository;
	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private ISiteEscalade siteMetier;
	@Autowired
	private CommentaireRepository commentaireRepository;
	@Autowired
	private Itopos toposMetier;
	@Autowired
	private Iregion regionMetier;
	@Autowired
private Icommentaire commentaireMetier;
	@Autowired
	private IReservation reservationMetier;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private IRole roleMetier;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
    public static void main(String[] args) {
        SpringApplication.run(SiteEscaladeApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		Roles role=new Roles("utilisateur");
		Roles membre=new Roles("membre");
		Roles admin=new Roles("admin");
		roleMetier.createRole(role);
		roleMetier.createRole(membre);
		roleMetier.createRole(admin);
	
		Region lyon=regionRepository.save(new Region("r0"));
		Region r1=regionRepository.save(new Region("r1"));
		Region r2=regionRepository.save(new Region("r2"));
		Region r3=regionRepository.save(new Region("r3"));
		Region r4=regionRepository.save(new Region("r4"));
		SiteEscalade site =  siteEscaladeRepository.save(new SiteEscalade("site1","adresse1","codePostal1","description1","non officiel","1 a 50","10 a 20","4",r1,"longueur1"));
		SiteEscalade s1 = siteEscaladeRepository.save(new SiteEscalade("site2","adresse2","codePostal2","description2","non officiel","50 a 100","10 a 20","4",r1,"longueur3")); 
		SiteEscalade s2 = siteEscaladeRepository.save(new SiteEscalade("site3","adresse1","codePostal1","description1","non officiel","50 a 100","10 a 20","4",r2,"longueur3"));
		SiteEscalade s3 = siteEscaladeRepository.save(new SiteEscalade("site4","adresse1","codePostal1","description1","non officiel","50 a 100","10 a 20","4",r3,"longueur3"));
		SiteEscalade s4 = siteEscaladeRepository.save(new SiteEscalade("site5","adresse1","codePostal1","description1","non officiel","1 a 50","10 a 20","4",r2,"longueur1"));
		Utilisateur u1=utilisateurMetier.createUtilisateur("u1", "mail1", "pw1",role);
		Utilisateur u2=utilisateurMetier.createUtilisateur("u2", "mail2", "pw2",role);
		Utilisateur u3=utilisateurMetier.createUtilisateur("u3", "mail3", "pw3",membre);
		Utilisateur u4=utilisateurMetier.createUtilisateur("u4", "mail4", "pw4",admin);
		commentaireMetier.createCommentaire(s1.getCodeSiteEscalade(), u1.getMail(), "des1");
		commentaireMetier.createCommentaire(s1.getCodeSiteEscalade(), u2.getMail(), "des2");
		commentaireMetier.createCommentaire(s1.getCodeSiteEscalade(), u3.getMail(), "des3");
		commentaireMetier.createCommentaire(s1.getCodeSiteEscalade(), u4.getMail(), "des4");
		
		
		commentaireRepository.save(new Commentaires(u1, new Date(), "description 1",s1));
		commentaireRepository.save(new Commentaires(u1, new Date(), "description 2",s1));
		commentaireRepository.save(new Commentaires(u1, new Date(), "description 3",s1));
		Topos t1 = toposMetier.createTopos(new Topos("topos 1", "description 1","Date1",u1,"disponible",lyon));
		toposMetier.createTopos(new Topos("topos 2", "description 1","Date1",u2,"disponible",r1));
		toposMetier.createTopos(new Topos("topos 3", "description 1","Date1",u3,"disponible",r2));
		toposMetier.createTopos(new Topos("topos 4", "description 1","Date1",u4,"disponible",r3));
		toposMetier.createTopos(new Topos("topos 5", "description 1","Date1",u4,"disponible",r4));

		CotationClasse cotation=new CotationClasse();
		List<Cotation>listCotations=cotation.listCotation();
		 LongueurClasse lg = new LongueurClasse();
		 List<Longueur>listLongueurs=lg.listLongueur();
		
		System.out.println(listCotations);
		
		System.out.println(listLongueurs);
		
		Reservation res1=reservationMetier.createReservation(new Reservation(t1 , u2, "demande",u1));
		Reservation res2=reservationMetier.createReservation(new Reservation(t1 , u2, "demande",u1));
		Reservation res3=reservationMetier.createReservation(new Reservation(t1 , u2, "demande",u1));
		
		
		UserDetails user= userDetailsService.loadUserByUsername("mail1");
	
		System.out.println(s1.getStatut()=="non officiel");
		
	}
}

		
		
		
		
		
	


