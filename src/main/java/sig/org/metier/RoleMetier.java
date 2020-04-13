package sig.org.metier;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sig.org.classe.Roles;
import sig.org.classe.Topos;
import sig.org.dao.RoleRepository;

@Service
@Transactional
public class RoleMetier implements IRole {
@Autowired
	private RoleRepository roleRepository;
/**
 * creation d'un roles
 * @param role
 */
@Override
	public Roles createRole(Roles role) {
		

		return roleRepository.save(role);        
	}
	
/**
 * retourne le role en fonction de son nom
 * @param nom
 */
public Optional<Roles> getbyNom(String nom) {
	
	
	Optional<Roles> role = roleRepository.findByNom(nom);
	
	return role;	
}



}
