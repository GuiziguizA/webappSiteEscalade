package sig.org.metier;





import java.util.List;
import java.util.Optional;

import sig.org.classe.Utilisateur;

public interface Iutilisateur {

	
	public Utilisateur createUtilisateur(String Nom, String mail, String passeword) throws Exception;
	public Utilisateur connectionUtilisateur(String mail, String pw) throws Exception;
	public Optional<Utilisateur> findByEmail(String mail);
	public List<Utilisateur>findAllUtilisateur();
}
