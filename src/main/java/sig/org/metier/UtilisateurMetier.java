package sig.org.metier;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
	
	private static Logger LOG = LoggerFactory.getLogger( UtilisateurMetier.class);
	/**
	 * Méthode créant un utilisateur
	 * 
	 * @param nom
	 * @param mail
	 * @param role
	 * 
	 * @return utilisateurRepository.save(user)
	 * @throws Exception 
	 */
	@Override
	public Utilisateur createUtilisateur( String nom,String mail,String password,Roles role) throws Exception{ 
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByMail(mail);
		Utilisateur user=new Utilisateur();

		if(utilisateur.isPresent()) {
		throw new Exception("Cette adresse e-mail est deja utilisé pour un compte Utilisateur");
				}else {
			
			user.setMail(mail);
			user.setPassword(passwordEncoder.encode(password));
			user.setNom(nom);
			
			user.setRoles(role);
		
		}
	
		LOG.info("creation du compte utilisateur ");

	
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
	 * @throws Exception 
	 */
	@Override
	public Utilisateur findByEmail(String mail) throws Exception {
		Optional<Utilisateur> utilisateur = null;
		
			utilisateur = utilisateurRepository.findByMail(mail);
	
			if (!utilisateur.isPresent()) {
				throw new Exception("l'utilisateur n'existe pas");
			}
			
	
		
		return utilisateur.get();
	}

	
	
	
	
	@Override
	public Utilisateur ModifierStatut(Long id) throws Exception {
		Optional<Utilisateur> utilisateur = null;
		
			utilisateur = utilisateurRepository.findById(id);
	
			if (!utilisateur.isPresent()) {
				throw new Exception("l'utilisateur n'existe pas");
			}else {	
				Optional<Roles> role1= roleRepository.findByNom("utilisateur");
			Optional<Roles> role2= roleRepository.findByNom("membre");
		if(utilisateur.get().getRoles().getNom().equals("utilisateur")) {
		
			 utilisateur.get().setRoles(role2.get());
			
		}else if (utilisateur.get().getRoles().getNom().equals("membre")){
			
			utilisateur.get().setRoles(role1.get());
			utilisateurRepository.save(utilisateur.get());
		}else { 
			throw new Exception("la modification statut utilisateur ne marche pas");
		}
		
			}
	return utilisateurRepository.save(utilisateur.get());
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
