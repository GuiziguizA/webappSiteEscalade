package sig.org.metier;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.RecordTypeNotSupportedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javassist.compiler.ast.NewExpr;
import sig.org.classe.Utilisateur;
import sig.org.dao.UtilisateurRepository;
@Service
@Transactional
public class UtilisateurMetier implements Iutilisateur {
	
	
@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Override
	public Utilisateur createUtilisateur( String nom,String mail,String passeword)throws Exception { 
	
Optional<Utilisateur> utilisateur = utilisateurRepository.findByMail(mail);

if(utilisateur.isPresent()) {
	throw new Exception("Cette adresse e-mail est deja utilisé pour un compte Utilisateur");
}
		Utilisateur user=new Utilisateur();
		
		user.setMail(mail);
		user.setPasseword(passeword);
		user.setNom(nom);
		
		
		
		return utilisateurRepository.save(user);
}
	
	
	public Optional<Utilisateur> connectionUtilisateur(String mail, String pw)throws Exception{
		
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByMailAndPasseword(mail, pw);
		
		if (!utilisateur.isPresent()) {
			
			
			
			throw new Exception("l'adresse mail ou le mot de passe est incorrect");
		}
			return utilisateur;
		
		
		
	}
	
}
