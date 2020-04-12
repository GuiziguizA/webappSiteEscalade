package sig.org.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sig.org.classe.Roles;
@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
	
	@Query("SELECT u FROM Roles u WHERE  u.nom=:u")	
	Optional<Roles>findByNom(@Param("u")String nom);

}
