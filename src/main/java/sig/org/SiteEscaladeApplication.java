package sig.org;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    private static final Logger LOGGER = LogManager.getLogger(SiteEscaladeApplication.class);
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
	@Autowired
	private SiteEscaladeRepository siteRepository;
	
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
	
		
		  
        LOGGER.info("Info level log message");
        LOGGER.debug("Debug level log message");
        LOGGER.error("Error level log message");
		
		Region r1=regionRepository.save(new Region("Bourgogne"));
		Region r2=regionRepository.save(new Region("Poitou-Charentes"));
		Region r3=regionRepository.save(new Region("Limousin"));
		Region r4=regionRepository.save(new Region("Auvergne"));
		SiteEscalade site =  siteEscaladeRepository.save(new SiteEscalade("Le site des Balbuzard","3 avenue du buisson","74556","Site agréable  situé justé en dessous des nids de balbuzards","non officiel","1 a 50","10 a 20","4",r1,"longueur1"));
		SiteEscalade s1 = siteEscaladeRepository.save(new SiteEscalade("Le site des bouleaux","5 rue des noisetiers","65231","Situé dans une forêts de bouleaux ce site est accueillant","non officiel","50 a 100","10 a 20","4",r1,"longueur3")); 
		SiteEscalade s2 = siteEscaladeRepository.save(new SiteEscalade("Le site des lacs","25 rue de Jeanne d'Arc","56231","Situé a côté de deux lacs, idéal pour ce baigner après une session ","non officiel","50 a 100","10 a 20","4",r2,"longueur3"));
		SiteEscalade s3 = siteEscaladeRepository.save(new SiteEscalade("Le site du granite","56 avenue de la feuille","98541","Site entièrement constitué de granite","non officiel","50 a 100","10 a 20","4",r3,"longueur3"));
		SiteEscalade s4 = siteEscaladeRepository.save(new SiteEscalade("Le site de Charente","90 rue de Mercure","56984","Site artificiel d'extérieure","non officiel","1 a 50","10 a 20","4",r2,"longueur1"));
		Utilisateur u1=utilisateurMetier.createUtilisateur("Gregoire", "Bob", "pw1",role);
		Utilisateur u2=utilisateurMetier.createUtilisateur("Arnold", "arnold", "pw2",role);
		Utilisateur u3=utilisateurMetier.createUtilisateur("JeanMichel", "JM", "pw3",membre);
		Utilisateur u4=utilisateurMetier.createUtilisateur("admin", "admin", "admin",admin);
		commentaireMetier.createCommentaire(s1.getCodeSiteEscalade(), u1.getMail(), "Site magnifique");
		commentaireMetier.createCommentaire(s1.getCodeSiteEscalade(), u2.getMail(), "je n'ai pas aimé l'ambiance");
		commentaireMetier.createCommentaire(s1.getCodeSiteEscalade(), u3.getMail(), "Les voies sont difficiles mais environnement agréable");
		commentaireMetier.createCommentaire(s1.getCodeSiteEscalade(), u4.getMail(), "J'ai trop aimé voir les rappaces chassés je conseille");
		
		
		
		Topos t1 = toposMetier.createTopos(new Topos("Topos B", "Topos de la Bourgogne","20/02/2020",u1,"disponible",r1));
		toposMetier.createTopos(new Topos("topos B", "Topos de la Bourgogne","Date1",u2,"disponible",r1));
		toposMetier.createTopos(new Topos("topos PC", "Topos du Poitou-Charentes","Date1",u3,"disponible",r2));
		toposMetier.createTopos(new Topos("topos L", "Topos du Limousin","Date1",u4,"disponible",r3));
		toposMetier.createTopos(new Topos("topos A", "Topos De l'Auvergne","Date1",u4,"disponible",r4));

	
	}
}

		
		
		
		
		
	


