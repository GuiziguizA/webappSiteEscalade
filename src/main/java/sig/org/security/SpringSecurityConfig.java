/*
 * package sig.org.security;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.web.access.AccessDeniedHandler;
 * 
 * @Configuration
 * 
 * public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
 * 
 * @Autowired private AccessDeniedHandler accessDeniedHandler;
 * 
 * 
 * @Override
 * 
 * @Bean protected void configure(HttpSecurity http) throws Exception {
 * 
 * http .authorizeRequests() .anyRequest().authenticated() .and() .formLogin()
 * .and() .httpBasic(); }
 * 
 * // create two users, admin and user
 * 
 * @Autowired public void configureGlobal(AuthenticationManagerBuilder auth)
 * throws Exception {
 * 
 * auth.inMemoryAuthentication() .withUser("user") .password("{noop}pass") //
 * Spring Security 5 requires specifying the password storage format ; } }
 */