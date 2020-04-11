package sig.org.metier;

import java.util.List;

import sig.org.classe.Topos;
import sig.org.classe.Utilisateur;




public interface Itopos {
	
	public void deleteToposById(Long codeCommentaire) throws  Exception;

	public Topos getToposById(Long  codeCommentaire) throws Exception;

	public List<Topos> getAllTopos();

	public Topos createTopos(Topos topos);

	public Topos updateStatutTopos(Topos topos) throws Exception;



	public List<Topos> getUtilisateurTopos(Utilisateur user);

	public Topos getNomTopos(String nom) throws Exception;

	public Topos getToposByCodeTopos(Long codeTopos) throws Exception;

	
	
}
