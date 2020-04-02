package sig.org.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sig.org.classe.Commentaires;
import sig.org.classe.SiteEscalade;



@Repository
public interface CommentaireRepository extends JpaRepository<Commentaires, Long>{


	List<Commentaires>findBySite(SiteEscalade site);
	
	
}
