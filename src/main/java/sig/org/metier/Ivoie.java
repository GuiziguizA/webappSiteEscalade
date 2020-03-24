package sig.org.metier;

import java.awt.print.Pageable;
import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.data.domain.Page;

import sig.org.classe.Voie;

public interface Ivoie {

	

	public void deleteVoieById(Long id) throws RelationNotFoundException, Exception;

	public Voie getVoieById(Long id) throws RelationNotFoundException;

	public List<Voie> getAllVoie();


	
	public Voie createVoie(String nom, String cotation, String longueur, Long codeSiteEscalade) throws Exception;

	public List<Voie> getVoieCritere(String name, String cotation, String longueur) throws Exception;

	

	public Page<Voie> getSiteEscalade(Long codeSiteEscalade, int page, int size) throws Exception;

	
}
