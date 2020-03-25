package sig.org.controlleur;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sig.org.classe.SiteEscalade;
import sig.org.classe.Voie;
import sig.org.dao.SiteEscaladeRepository;
import sig.org.dao.VoieRepository;
import sig.org.metier.ISiteEscalade;
import sig.org.metier.VoieMetier;

@Controller
@ControllerAdvice 		
public class SiteControlleur {
@Autowired
private VoieRepository voieRepository;	
@Autowired
private SiteEscaladeRepository siteRepository; 
@Autowired
private ISiteEscalade siteMetier;	
@Autowired
private VoieMetier voieMetier;
	
	@GetMapping("/Site")
	public String viewSite(){
		
		return "Site";
	}
	
	@GetMapping("/consulterVoie")

public String consulterVoie(Model model){
		List<SiteEscalade> listSite=siteMetier.getSiteEscalade();
	
		   
		model.addAttribute("listSite", listSite);
		
		
		
	
		 
		  
		return "Site";
	}
	
	
RequestMapping("/consulterVoie")
public String afficherVoie(Long CodeSite,Model model) {
	  try {
		  
		  Page<Voie>listVoieSite =voieMetier.getSiteEscalade(codeSite, 0,3);
		  model.addAttribute("listVoie",listVoieSite.getContent() );
		  
		  } catch (Exception e) { // TODO Auto-generated catch block
		  model.addAttribute("exception",e); }
	
	return "Site";
}
	
	
	
	
	
}
