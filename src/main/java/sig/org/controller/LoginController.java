package sig.org.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sig.org.classe.Utilisateur;
import sig.org.dao.UtilisateurRepository;
import sig.org.metier.Iutilisateur;

 
@Controller
public class LoginController {
@Autowired
private UtilisateurRepository userRepository;	
@Autowired
private Iutilisateur userMetier;
	

@GetMapping("/login") 
public String login() {
	
	  return "login"; }


@PostMapping("/login") 
public String connexionUtilisateur(@RequestParam("mail")String mail,@RequestParam("passeword")String pw,Model model) {
	try {
		Utilisateur user= userRepository.findByMailAndPasseword(mail, pw);
		
		if(!user.isPresent()) {
			
		}
	} catch (Exception e) {
		model.addAttribute("exception",e);
	}




	return  "Site";
	 }





@GetMapping("/adduser") 
public String index() {
	
	  return "add-user"; }








    @PostMapping( "/adduser")
    public String adduser( String mail,String nom,String pw, Model model) {
    	
   try {
	 	
   	Optional<Utilisateur> u1 = userRepository.findByMail(mail);
   	if(!u1.isPresent()) {
   		userMetier.createUtilisateur(nom,mail,pw);
   	}
   	
} catch (Exception e) {
	model.addAttribute("exception",e);
}
		return "login";
       //logic to process input data
    }

	
	
	 
	    
	/*
	 * @PostMapping("/adduser") public String addUser(@Valid Utilisateur user,
	 * BindingResult result, Model model) { if (result.hasErrors()) { return
	 * "add-user"; }
	 * 
	 * userRepository.save(user); model.addAttribute("users",
	 * userRepository.findAll()); return "index"; }
	 * 
	 * @PostMapping("/update/{id}") public String updateUser(@PathVariable("id")
	 * long id, @Valid Utilisateur user, BindingResult result, Model model) { if
	 * (result.hasErrors()) { user.getCodeUtilisateur(id); return "update-user"; }
	 * 
	 * userRepository.save(user); model.addAttribute("users",
	 * userRepository.findAll()); return "index"; }
	 */
	 
}