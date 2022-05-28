package ph.mramos.vcps.section09.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // No need to add @Configuration if either @EnableWebSecurity or @EnableGlobalMethodSecurity is present since they are both meta annotated by @Configuration.
//@EnableWebSecurity // Not needed in Spring Boot app, can be completely removed.
//@EnableGlobalMethodSecurity(prePostEnabled = true) // To add method security.
public class SampleWebSecurityConfig extends WebSecurityConfigurerAdapter { // Extending WebSecurityConfigurerAdapter and having @Configuration (including meta annotated) turns off the auto config.

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.anyRequest().authenticated()
				.and()
			.formLogin().and()
//			.httpBasic().and()
			.requiresChannel()
				.anyRequest().requiresSecure()
				.and();
//			.headers()
//				.frameOptions().sameOrigin() // Must be present otherwise h2-console will have broken iFrames.
//				.and()
//			.csrf().disable(); // Must be present otherwise h2-console will result to a not found error.
	}

}
