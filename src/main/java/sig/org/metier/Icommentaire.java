package sig.org.metier;

import java.util.List;


import sig.org.classe.Commentaires;
import sig.org.classe.SiteEscalade;

public interface Icommentaire {

	public void deleteCommentaireById(Long id) throws  Exception;

	public Commentaires getCommentaireById(Long id) throws Exception;



	public Commentaires createCommentaire(Long codeSiteEscalade, Long codeUtilisateur, String description) throws Exception;


	public List<Commentaires> getSiteAllCommentaire(SiteEscalade siteEscalade, Long codeSiteEscalade) throws Exception;

}
