package sig.org.metier;

import java.util.List;


import sig.org.classe.Commentaires;
import sig.org.classe.SiteEscalade;

public interface Icommentaire {

	public void deleteCommentaireById(Long id) throws  Exception;

	public Commentaires getCommentaireById(Long id) throws Exception;



	public Commentaires createCommentaire(Long codeSiteEscalade, String mail, String description) throws Exception;



	public List<Commentaires> getSiteAllCommentaire(Long codeSiteEscalade) throws Exception;

	public Commentaires updateCommentaireById(Long codeCommentaire, String description) throws Exception;

	

	
	

}
