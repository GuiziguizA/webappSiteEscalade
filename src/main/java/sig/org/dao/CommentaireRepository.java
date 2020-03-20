package sig.org.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sig.org.classe.Commentaires;
import sig.org.classe.SiteEscalade;




public interface CommentaireRepository extends JpaRepository<Commentaires, Long>{


	List<Commentaires>findBySite(SiteEscalade site);
	
	
}
