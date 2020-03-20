package sig.org.dao;

import sig.org.classe.Utilisateur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository
extends JpaRepository<Utilisateur, Long>{

Optional<Utilisateur> findByMail(String mail);

Optional<Utilisateur> findByMailAndPasseword(String mail, String Passeword);

}
