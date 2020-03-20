package sig.org.metier;



import java.util.Optional;

import sig.org.classe.Utilisateur;

public interface Iutilisateur {


	public Utilisateur createUtilisateur(String Nom, String mail, String passeword) throws Exception;
	public Optional<Utilisateur> connectionUtilisateur(String mail, String pw) throws Exception;
}
