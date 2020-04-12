package sig.org.metier;





import java.util.List;
import java.util.Optional;

import sig.org.classe.Roles;
import sig.org.classe.Utilisateur;

public interface Iutilisateur {

	
	public Utilisateur createUtilisateur(String nom, String mail, String password, Roles role);
	public Utilisateur connectionUtilisateur(String mail, String pw) throws Exception;
	public Optional<Utilisateur> findByEmail(String mail);
	public List<Utilisateur>findAllUtilisateur();
	public String utilisateurConnecté() throws Exception;
	public Utilisateur getNom(String nom) throws Exception;
	
}
