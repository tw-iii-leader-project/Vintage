package tw.leader.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tw.leader.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
		.maximumSessions(1);
		//Create personal session to save login information, 
		//and then set the max session to 1 to prevent multiple login for one user.
		//When user logout, the session create when login would be expired.
				
		http
			.authorizeRequests()
			.antMatchers("/list_users").authenticated()
//			.antMatchers("/admin", "/admin2").hasRole("ADMIN")
//			.antMatchers("/sellerOnly", "/sellerOnly2").hasAnyRole("ADMIN", "SELLER")
//			.antMatchers("/").hasAnyRole("ADMIN", "USER", "SELLER")
			.anyRequest().permitAll()
			.and()
			.formLogin()
				.usernameParameter("email")
				.loginPage("/loginPage")
				.loginProcessingUrl("/perform_login")
				.defaultSuccessUrl("/toHomePage")
				.failureUrl("/loginPage?error")
				.permitAll()
			.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/home").permitAll();
	}
	
	
}
