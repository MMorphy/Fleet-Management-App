package hr.petkovic.fleet.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
				.usersByUsernameQuery("select username, password, true as enabled from users where username=?")
				.authoritiesByUsernameQuery("select username, roles.name as authority "
						+ "from users join user_roles on users.id=user_roles.user_id "
						+ "join roles on roles.id=user_roles.role_id where username=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/user/registration/**").permitAll().antMatchers("/login").permitAll()
				.antMatchers("/logout").permitAll().antMatchers("/").permitAll().antMatchers("/reservation/**")
				.hasRole("OPER").antMatchers("/reservation/add/**").authenticated()
				.antMatchers("/office/administration/").hasRole("OPER").antMatchers("/reservation/administration/**")
				.hasRole("OPER").antMatchers("/option/reservation/**").hasRole("OPER")
				.antMatchers("/workingHours/administration/**").hasRole("OPER")
				.antMatchers("/vehicle/administration/**").hasRole("OPER").antMatchers("/office/vehicles/**")
				.hasRole("OPER").antMatchers("/tires/administration/**").hasRole("OPER")
				.antMatchers("/specification/administration/**").hasRole("OPER")
				.antMatchers("/damage/administration/vehicle/**").hasRole("OPER")
				.antMatchers("/navigation/administration/**").hasRole("OPER").antMatchers("/damage/fix/**")
				.hasRole("OPER").antMatchers("/img/**").permitAll().antMatchers("/**").hasRole("ADMIN").and()
				.formLogin().loginPage("/login").defaultSuccessUrl("/", true).and().logout().logoutUrl("/logout")
				.logoutSuccessUrl("/").and().exceptionHandling().accessDeniedPage("/forbidden");
		http.cors().disable();
	}
}
