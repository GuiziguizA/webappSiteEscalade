package sig.org.metier;

import java.util.List;

import javax.management.relation.RelationNotFoundException;


import org.springframework.data.domain.Page;

import sig.org.classe.Region;
import sig.org.classe.SiteEscalade;

public interface ISiteEscalade {

	public SiteEscalade afficherSiteEscaladeParRegion(Long Region) throws RelationNotFoundException;
	public SiteEscalade  afficherSiteEscalade(Long codeSite) throws RelationNotFoundException;
	public List<SiteEscalade>getSiteEscalade();
	public SiteEscalade createSiteEscalade(SiteEscalade site) throws Exception;
	public List<SiteEscalade> getSiteEscaladeCritere(String cotationMax, String longueurMax, String nombreDeSecteur,
			String nombreDeVoie, Region region) throws Exception;

}
