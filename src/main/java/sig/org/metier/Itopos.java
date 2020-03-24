package sig.org.metier;

import java.util.List;

import sig.org.classe.Topos;




public interface Itopos {

	

	


	public void deleteToposById(Long codeCommentaire) throws  Exception;

	public Topos getToposById(Long  codeCommentaire) throws Exception;

	public List<Topos> getAllTopos();

	

	public Topos createTopos(String statut, Long codeRegion, Long codeUtilisateur, String dateDeParuption, String description,
			String nom) throws Exception;
}
