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
		List<SiteEscalade>listSite=siteMetier.getSiteEscalade();
		System.out.println(listSite);
	if(listSite == null || listSite.isEmpty()) {
		System.out.println("yo les man");
		}else {System.out.println("bibibibibibibi");}
		
	
		
	}
}

		
		
		
		
		
	


