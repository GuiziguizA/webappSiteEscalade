package sig.org.metier;

import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.jca.cci.RecordTypeNotSupportedException;

import sig.org.classe.Commentaires;
import sig.org.classe.Region;
import sig.org.classe.Topos;
import sig.org.classe.Utilisateur;


public interface Itopos {

	

	


	public void deleteToposById(Long codeCommentaire) throws  Exception;

	public Topos getToposById(Long  codeCommentaire) throws Exception;

	public List<Topos> getAllTopos();

	

	public Topos createTopos(String statut, Long codeRegion, Long codeUtilisateur, String dateDeParuption, String description,
			String nom) throws Exception;
}
