package sig.org.metier;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import sig.org.classe.Utilisateur;
import sig.org.dao.UtilisateurRepository;
@Service
@Transactional
public class UtilisateurMetier implements Iutilisateur  {
	
	
@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Override
	public Utilisateur createUtilisateur( String nom,String mail,String passeword){ 
	Optional<Utilisateur> utilisateur = utilisateurRepository.findByMail(mail);
	Utilisateur user=new Utilisateur();

	if(utilisateur.isPresent()) {
		System.out.println("Cette adresse e-mail est deja utilisé pour un compte Utilisateur");
	}else {
			
			
			user.setMail(mail);
			user.setPasseword(passeword);
			user.setNom(nom);
			
	}
	

	
return utilisateurRepository.save(user);
		
		
}
	
	
	@Override
	public Utilisateur connectionUtilisateur(String mail, String pw)throws Exception{
		
		Utilisateur utilisateur = utilisateurRepository.findByMailAndPasseword(mail, pw);
		
		if (!utilisateur.isPresent()) {
			
			
			
			throw new Exception("l'adresse mail ou le mot de passe est incorrect");
		}
			return utilisateur;
		
		
		
	}

	

	@Override
	public Optional<Utilisateur> findByEmail(String mail) {
		Optional<Utilisateur> utilisateur = null;
		try {
			utilisateur = utilisateurRepository.findByMail(mail);
		} catch (Exception e) {
			throw e;
		}

	
		
		return utilisateur;
	}

}
