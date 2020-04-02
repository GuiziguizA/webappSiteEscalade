package sig.org.metier;


import java.util.List;
import java.util.Optional;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import sig.org.classe.Utilisateur;

import sig.org.dao.UtilisateurRepository;


@Service
@Transactional
public class UtilisateurMetier implements Iutilisateur  {
	
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	PasswordEncoder passwordEncoder;
	/**
	 * Méthode créant un utilisateur
	 * 
	 * @param utilisateur : utilisateur correspondant au mail dans le repository
	 * @param user : creation d'un objet Utilisateur
	 * 
	 * @return utilisateurRepository.save(user)
	 */
	@Override
	public Utilisateur createUtilisateur( String nom,String mail,String password){ 
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByMail(mail);
		Utilisateur user=new Utilisateur();

		if(utilisateur.isPresent()) {
			System.out.println("Cette adresse e-mail est deja utilisé pour un compte Utilisateur");
		}else {
			
			user.setMail(mail);
			user.setPassword(passwordEncoder.encode(password));
			user.setNom(nom);

		
		}
	

	
		return utilisateurRepository.save(user);
	}
	
	/**
	 * Methode 
	 */
	
	@Override
	public Utilisateur connectionUtilisateur(String mail, String pw)throws Exception{
		
		Utilisateur utilisateur = utilisateurRepository.findByMailAndPassword(mail, pw);
		
		if (!utilisateur.isPresent()) {
			
			
			
			throw new Exception("l'adresse mail ou le mot de passe est incorrect");
		}
			return utilisateur;	
	}

	/**
	 * Methode renvoyant la liste de tous les utilisateurs
	 * 
	 * @param listUtilisateur : liste de tout les utilisateurs
	 * 
	 * @return listUtilisateur
	 */
	public List<Utilisateur>findAllUtilisateur(){
		List<Utilisateur>listUtilisateur = (List<Utilisateur>) utilisateurRepository.findAll();
		
		return listUtilisateur;	
	}
	
	/**
	 * Methode retournant un utilisateur en fonction d'un mail
	 * 
	 * @param utilisateur : utilisateur du repository correspondant au mail
	 * 
	 * @return utilisateur
	 */
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
