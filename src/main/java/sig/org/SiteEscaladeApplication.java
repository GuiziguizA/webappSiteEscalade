package sig.org;




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
import sig.org.dao.UtilisateurRepository;
import sig.org.dao.VoieRepository;
import sig.org.metier.Iutilisateur;
import sig.org.metier.UtilisateurMetier;


import sig.org.classe.Commentaires;

import sig.org.classe.Topos;


import sig.org.dao.CommentaireRepository;
import sig.org.dao.RegionRepository;
import sig.org.dao.SiteEscaladeRepository;
import sig.org.dao.ToposRepository;
import sig.org.dao.UtilisateurRepository;
import sig.org.dao.VoieRepository;
import sig.org.metier.ISiteEscalade;
import sig.org.metier.Icommentaire;
import sig.org.metier.Itopos;
import sig.org.metier.Iutilisateur;
import sig.org.metier.Ivoie;











@SpringBootApplication
public class SiteEscaladeApplication implements CommandLineRunner {
	
	@Autowired
	private UtilisateurMetier utilisateurMetier;
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private SiteEscaladeRepository siteEscaladeRepository;
	@Autowired
	private RegionRepository regionRepository;
	@Autowired
	private VoieRepository voieRepository;
	@Autowired
	private ISiteEscalade siteMetier;
	
	
	
	
    public static void main(String[] args) {
        SpringApplication.run(SiteEscaladeApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		
		
		Region lyon=regionRepository.save(new Region("lyon"));
		SiteEscalade s1 = siteEscaladeRepository.save(new SiteEscalade("les site des trvdsuff","45 rue du facon" ,"65230","Site eclaté au sol",lyon,"RAS")); 
		SiteEscalade s2 = siteEscaladeRepository.save(new SiteEscalade("les site desvsdvs truff","45 ruevsdv du facon" ,"652vdsv30","Sitvdsve eclaté au sol",lyon,"RAS")); 
		SiteEscalade s3 = siteEscaladeRepository.save(new SiteEscalade("les sitevsv des truff","45 rue duvdsv facon" ,"652dvs30","Site evdsvclaté au sol",lyon,"RAS")); 
		SiteEscalade s4 = siteEscaladeRepository.save(new SiteEscalade("les sitvsdve des truff","45 rue du favdsvcon" ,"65vs230","Site evdvsclaté au sol",lyon,"RAS")); 
		Voie v1 = voieRepository.save(new Voie("ddd","45","65",s1));
		Voie v2 = voieRepository.save(new Voie("ddddd","455","645",s1));
		Voie v3 = voieRepository.save(new Voie("dqqqdd","4dd5","6455",s1));
		Voie v4 = voieRepository.save(new Voie("dddhh","4hhh5","6h5",s1));
		Voie v5 = voieRepository.save(new Voie("dgfdgdd","4d5","6hh5",s1));
		Voie v6 = voieRepository.save(new Voie("dgfdgdd","45ggf","6fgdg5",s1));
		List<SiteEscalade>listedessite=siteMetier.getSiteEscalade();
		System.out.println(listedessite);
		System.out.println("hellllllllllllllllllllooooooooooooooooooooooooooo");
		
		
		// TODO Auto-generated method stub
		/*utilisateurMetier.createUtilisateur("guillaume","gualisse@gmail.com", "tarot");
		 * utilisateurMetier.createUtilisateur("bob","Bob@gmail.com", "bozo");
		 * utilisateurRepository.save(new Utilisateur("pijocsdci", "Bobby",
		 * "guiejisc@gmail.com")); Region lyon=regionRepository.save(new
		 * Region("lyon")); siteEscaladeRepository.save(new
		 * SiteEscalade("bob","bob","92330","yoyooy",lyon,"RAS"));
		 * 
		 */
		
	}
}

		/*
		 utilisateurMetier.createUtilisateur("bob","Bob@gmail.com", "bozo");
		 * utilisateurMetier.createUtilisateur("boba","Boba@gmail.com", "bozou");
		 * utilisateurMetier.createUtilisateur("bobu","Bobu@gmail.com", "bozto");
		 * utilisateurMetier.createUtilisateur("bobs","Bobsa@gmail.com", "bohhzo");
		 * utilisateurMetier.createUtilisateur("boba","Bobsad@gmail.com", "bddozo");
		 * 
		 * 
		 * 
		 * Region lyon=regionRepository.save(new Region("lyon")); Region
		 * paris=regionRepository.save(new Region("paris")); Region
		 * marseille=regionRepository.save(new Region("marseille")); Region
		 * biarritz=regionRepository.save(new Region("saint etienne")); Region
		 * nice=regionRepository.save(new Region("biarritz"));
		 * 
		 * SiteEscalade s1 = siteEscaladeRepository.save(new
		 * SiteEscalade("les site des truff","45 rue du facon"
		 * ,"65230","Site eclaté au sol",lyon,"RAS")); SiteEscalade s2 =
		 * siteEscaladeRepository.save(new
		 * SiteEscalade("les site des truffad","45 rue du fackjjjjon"
		 * ,"6541230","Site eclaté au sol",paris,"RAS")); SiteEscalade s3 =
		 * siteEscaladeRepository.save(new
		 * SiteEscalade("les site des truffadda","45 rue dunxfghnq facon"
		 * ,"6125230","Site eclaté au sol",biarritz,"RAS")); SiteEscalade s4 =
		 * siteEscaladeRepository.save(new
		 * SiteEscalade("les site des trufadadaf","45 rue du facon"
		 * ,"65kiu230","S5472ite eclaté au sol",marseille,"RAS")); SiteEscalade s5 =
		 * siteEscaladeRepository.save(new
		 * SiteEscalade("les site des truadzdff","45 rue du facon"
		 * ,"65kik230","Siteikuk eclaté au sol",nice,"RAS"));
		 * 
		 * Utilisateur u1 = utilisateurRepository.save(new Utilisateur("pijocsdci",
		 * "Bobby", "guiejisc@gmail.com"));
		 * 
		 * Commentaires c1 = commentaireRepository.save(new Commentaires(u1, new Date(),
		 * "yo ma gueule")); Commentaires c4
		 * =commentaireMetier.createCommentaire(s3.getCodeSiteEscalade(),
		 * u1.getCodeUtilisateur(), "damso");
		 * 
		 * Topos t1=toposRepository.save(new
		 * Topos("dortiyi","dokfoperjoijgidfgj","454545",u1,"hdfdsiohf",lyon));
		 * 
		 * 
		 * commentaireMetier.createCommentaire(s1.getCodeSiteEscalade(),
		 * u1.getCodeUtilisateur(), "yo ma caille");
		 * 
		 */
		
		
		
		
	


