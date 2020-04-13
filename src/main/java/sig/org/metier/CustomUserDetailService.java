package sig.org.metier;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import static java.util.Collections.emptyList;
import sig.org.classe.Utilisateur;
import sig.org.dao.UtilisateurRepository;
@Service
public class CustomUserDetailService implements UserDetailsService{
	
	
	
	
	@Autowired
private UtilisateurRepository utilisateurRepository;
	
	
	/**
	 * Modifie le User details de spring data security en identifiant l'utilisateur par son mail dans BD
	 * @param mail
	 * @return User.withUsername(utilisateur.get().getMail())
        .password( utilisateur.get().getPassword())
        .roles(utilisateur.get().getRole().getNom()).build();
	 */
	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
		Optional<Utilisateur> utilisateur=utilisateurRepository.findByMail(mail);
		
		if(!utilisateur.isPresent()) {
			throw new UsernameNotFoundException("l'utilisateurn'existe pas ");
		}
		
		
		/*
		 * return new User(utilisateur.get().getMail(),
		 * utilisateur.get().getPassword(),utilisateur.get().getRole().getNom());
		 * 
		 */
		return  User.withUsername(utilisateur.get().getMail())
        .password( utilisateur.get().getPassword())
        .roles(utilisateur.get().getRole().getNom()).build();
	}

}
