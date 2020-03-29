package sig.org.dao;

import sig.org.classe.Utilisateur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long>{

Utilisateur findByMailAndPasseword(String mail, String Passeword);

@Query("SELECT u FROM Utilisateur u WHERE  u.mail=:mail")
Optional<Utilisateur> findByMail(@Param("mail")String mail);


}
