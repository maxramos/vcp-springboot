package ph.mramos.vcps.section09.security;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatWebServerConfig {

	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> httpConnectorCustomizer() {
		Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
		connector.setPort(8080);

		return tomcat -> tomcat.addAdditionalTomcatConnectors(connector);
	}

}
