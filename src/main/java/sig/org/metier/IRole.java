package sig.org.metier;

import java.util.Optional;

import sig.org.classe.Roles;

public interface IRole {

	public Roles createRole(Roles role) ;
	public Optional<Roles> getbyNom(String nom);
	
}
