package sig.org.metier;

import javax.management.relation.RelationNotFoundException;

import sig.org.classe.SiteEscalade;

public interface ISiteEscalade {

	SiteEscalade afficherSiteEscaladeParRegion(Long Region) throws RelationNotFoundException;

}
