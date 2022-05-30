package ph.mramos.management;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.actuate.autoconfigure.web.ManagementContextConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;

@ManagementContextConfiguration // Note that this must not be scanned by @ComponenetScan and instead instantiated through META-INF/spring.factories
public class ActuatorWebServerConfig {

	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> actuatorConnectorCustomizer() {
		Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
		connector.setPort(9090);

		return factory -> factory.addAdditionalTomcatConnectors(connector);
	}

}
