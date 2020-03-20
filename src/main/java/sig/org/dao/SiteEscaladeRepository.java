package sig.org.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sig.org.classe.SiteEscalade;
import sig.org.classe.Voie;

public interface SiteEscaladeRepository 
extends JpaRepository<SiteEscalade, Long>{

}
