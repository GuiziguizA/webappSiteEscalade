package sig.org.metier;





import java.util.List;
import java.util.Optional;

import sig.org.classe.Roles;
import sig.org.classe.Utilisateur;

public interface Iutilisateur {

	
	public Utilisateur createUtilisateur(String nom, String mail, String password, Roles role);
	public Utilisateur findByEmail(String mail) throws Exception;
	public List<Utilisateur>findAllUtilisateur();
	
	public Utilisateur getByNom(String nom) throws Exception;
	
	
}
