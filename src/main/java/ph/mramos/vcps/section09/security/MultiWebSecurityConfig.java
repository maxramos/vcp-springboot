package ph.mramos.vcps.section09.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration // No need to add @Configuration if either @EnableWebSecurity or @EnableGlobalMethodSecurity is present since they are both meta annotated by @Configuration.
//@EnableWebSecurity // Not needed in Spring Boot app, can be completely removed.
@EnableGlobalMethodSecurity(prePostEnabled = true) // To add method security.
public class MultiWebSecurityConfig { // Extending WebSecurityConfigurerAdapter and having @Configuration (including meta annotated) turns off the auto config.

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
//				.passwordEncoder(NoOpPasswordEncoder.getInstance()) // Must have a noop password encoder set if no prefix is provided to prevent errors.
				.withUser("max")
					.password("{noop}password1") // If there's no prefix set then no need to set explicitly the password encoder. By default it will be the DelegatingPasswordEncoder.
					.roles("admin")
					.and()
				.withUser("therese")
					.password("{noop}password2")
					.roles("user");
	}

	@Configuration
	@Order(1)
	public static class ActuatorWebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.requestMatcher(EndpointRequest.toAnyEndpoint())
				.authorizeRequests()
					.anyRequest().hasRole("admin")
					.and()
				.formLogin().and()
				.httpBasic().and()
				.csrf().disable() // Must be added so that POST requests for actuators (e.g. setting a specific log level) are processed.
				.requiresChannel()
					.anyRequest().requiresSecure()
					.and()
				.portMapper()
					.http(9090).mapsTo(9443) // Port mapper is required since only 80 and 8080 are being redirected to their respective secured port (e.g. 443, 8443).
					.and();
		}

	}

	@Configuration
	public static class UiWebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.authorizeRequests()
					.anyRequest().authenticated()
					.and()
				.formLogin().and()
//				.httpBasic().and()
				.requiresChannel()
					.anyRequest().requiresSecure()
					.and(); // No need to add a port mapper since default port is 8080, it will be redirected to 8443 automatically.
//				.headers()
//					.frameOptions().sameOrigin() // Must be present otherwise h2-console will have broken iFrames.
//					.and()
//				.csrf().disable(); // Must be present otherwise h2-console will result to a not found error.
		}

	}

}
