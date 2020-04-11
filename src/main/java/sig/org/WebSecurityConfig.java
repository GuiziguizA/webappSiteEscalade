package sig.org;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;






@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().antMatchers("/css/**", "/js/**", "/webjars/**","/consulterFormulaireUtilisateur","/ajouterUtilisateur").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
		.defaultSuccessUrl("/consulterHome")
		.and()
		.logout()
		.logoutSuccessUrl("/login");
			
		
	}

	/*
	 * @Bean
	 * 
	 * @Override public UserDetailsService userDetailsService() {
	 * 
	 * 
	 * UserDetails user = User.withDefaultPasswordEncoder() .username("admin")
	 * .password("123") .roles("ADMIN") .build();
	 * 
	 * return new InMemoryUserDetailsManager(user);
	 * 
	 * 
	 * 
	 * }
	 */
	 
	
	
	/*
	 * @Override
	 * 
	 * @Bean public AuthenticationManager authenticationManagerBean() throws
	 * Exception { return super.authenticationManagerBean(); }
	 */
	
	
	}
