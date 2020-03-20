package sig.org.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import sig.org.classe.Topos;
import sig.org.classe.Voie;

public interface ToposRepository 
extends JpaRepository<Topos, Long>{
	
	
}
