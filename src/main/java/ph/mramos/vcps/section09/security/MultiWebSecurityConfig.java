package ph.mramos.vcps.section09.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity // Not needed in Spring Boot app, can be completely removed.
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MultiWebSecurityConfig {

//	@Configuration
//	@Order(1)
//	public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http
//				.antMatcher("/api/**")
//				.authorizeRequests()
//					.antMatchers("/api/**").authenticated()
//					.and()
//				.httpBasic();
//		}
//	}

	@Configuration
	@Order(2) // No need to specify @Order since it will default to lowest order.
	public static class FormLoginWebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.authorizeRequests()
					.antMatchers("/**").authenticated()
					.and()
				.headers()
					.frameOptions().disable() // Must be present otherwise h2-console will have broken frames.
					.and()
				.csrf().disable() // Must be present otherwise h2-console will result to not found error.
				.formLogin();
		}
	}

}
