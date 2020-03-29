package sig.org.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sig.org.classe.Voie;
import sig.org.metier.Ivoie;
import sig.org.metier.VoieMetier;

@Controller
public class VoieController {

private Ivoie voieMetier;	
	
@GetMapping("/consulterVoie")
public String consulterVoie(Model model)	{

	try {
		List<Voie>listVoie = voieMetier.getAllVoie()	;
		model.addAttribute(listVoie);
	} catch (Exception e) {
		model.addAttribute(e);
	}

	
return "listVoie"	;
	
}
	


@GetMapping("/consulterFormulaireVoie")
public String consulterVoie(Voie voie)	{
	

	
return "formulaireVoie"	;
	
}

	
}
