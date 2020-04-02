package sig.org.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sig.org.classe.Utilisateur;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

	

	@Query("SELECT u FROM Utilisateur u WHERE  u.mail=:mail")
	public Optional< Utilisateur> findByMail(@Param("mail")String mail);

	public Utilisateur findByMailAndPassword(String mail, String pw);

	
}
