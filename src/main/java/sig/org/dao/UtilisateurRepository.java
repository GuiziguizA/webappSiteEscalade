package sig.org.dao;

import sig.org.classe.Utilisateur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long>{

	

	@Query("SELECT u FROM Utilisateur u WHERE  u.mail=:mail")
	public Optional<Utilisateur> findByMail(@Param("mail")String mail);

	public Utilisateur findByMailAndPassword(String mail, String pw);


}
