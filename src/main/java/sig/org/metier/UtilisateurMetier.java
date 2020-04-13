package sig.org.metier;


import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sig.org.classe.Roles;
import sig.org.classe.Utilisateur;
import sig.org.dao.RoleRepository;
import sig.org.dao.UtilisateurRepository;


@Service
@Transactional
public class UtilisateurMetier implements Iutilisateur  {
	
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	/**
	 * Méthode créant un utilisateur
	 * 
	 * @param nom
	 * @param mail
	 * @param role
	 * 
	 * @return utilisateurRepository.save(user)
	 */
	@Override
	public Utilisateur createUtilisateur( String nom,String mail,String password,Roles role){ 
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByMail(mail);
		Utilisateur user=new Utilisateur();

		if(utilisateur.isPresent()) {
			System.out.println("Cette adresse e-mail est deja utilisé pour un compte Utilisateur");
		}else {
			
			user.setMail(mail);
			user.setPassword(passwordEncoder.encode(password));
			user.setNom(nom);
			
			user.setRole(role);
		
		}
	

	
		return utilisateurRepository.save(user);
	}
	

	/**
	 * Methode renvoyant la liste de tous les utilisateurs
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
	 * @param mail
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

	
/**
 * retourne utilisateur en fonction de son nom
 *  @param nom
 *  @return utilisateur.get()
 */
	
	
	@Override
	public Utilisateur getByNom(String nom) throws Exception {
		
		Optional<Utilisateur>utilisateur=utilisateurRepository.findByNom(nom);
		if (!utilisateur.isPresent()) {
			throw new Exception("l'utilisateur n'existe pas");
		}
		
	
			
	return utilisateur.get();
		
	}
	
}
