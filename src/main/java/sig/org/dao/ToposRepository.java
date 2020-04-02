package sig.org.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sig.org.classe.Topos;

@Repository
public interface ToposRepository extends JpaRepository<Topos, Long>{
	
	
}
