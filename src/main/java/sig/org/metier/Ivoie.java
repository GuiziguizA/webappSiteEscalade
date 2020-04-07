package sig.org.metier;


import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RelationNotFoundException;

import sig.org.classe.SiteEscalade;
import sig.org.classe.Voie;

public interface Ivoie {

	

	public void deleteVoieById(Long id) throws RelationNotFoundException, Exception;

	public Voie getVoieById(Long id) throws RelationNotFoundException;

	  public List<Voie> getAllVoie();


	


	public 	List<Voie> getVoieCritere(String cotation, String longueur) throws Exception;


	

	public List<Voie> getSiteEscalade(Long codeSite) throws Exception;

	public Voie createVoie(Voie voie) throws Exception;



	
	
}
