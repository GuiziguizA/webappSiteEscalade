/*
 * package sig.org.controller;
 * 
 * import java.util.Optional;
 * 
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.stereotype.Controller;
 * 
 * import org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody;
 * 
 * import sig.org.classe.Utilisateur; import sig.org.classe.UtilisateurLogin;
 * 
 * import sig.org.metier.Iutilisateur;
 * 
 * 
 * @Controller public class LoginController {
 * 
 * 
 * 
 * @Autowired private UserDetailsService userDetailsService;
 * 
 *//**
	 * Inject the UserService dependency to be able to invoke the services present
	 * in its interface
	 */
/*
 * @Autowired private Iutilisateur utilisateurMetier;
 * 
 *//**
	 * Inject the AuthenticationManager dependency
	 *//*
		 * @Autowired private AuthenticationManager authenticationManager;
		 * 
		 * @PostMapping("/authentification") public ResponseEntity<Utilisateur>
		 * login(@RequestBody UtilisateurLogin utilisateurLogin){
		 * 
		 * UserDetails
		 * userDetails=userDetailsService.loadUserByUsername(utilisateurLogin.getMail())
		 * ; UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
		 * new UsernamePasswordAuthenticationToken(userDetails,
		 * utilisateurLogin.getPassword(),userDetails.getAuthorities());
		 * authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		 * if(usernamePasswordAuthenticationToken.isAuthenticated()){
		 * SecurityContextHolder.getContext().setAuthentication(
		 * usernamePasswordAuthenticationToken); Optional<Utilisateur>
		 * utilisateur=utilisateurMetier.findByEmail(utilisateurLogin.getMail());
		 * utilisateur.get().setPassword(""); return new
		 * ResponseEntity<>(utilisateur.get(),HttpStatus.OK); }
		 * 
		 * return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * }
		 */