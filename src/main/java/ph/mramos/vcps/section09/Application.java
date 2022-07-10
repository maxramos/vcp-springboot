package ph.mramos.vcps.section09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Default entity scanning starts where the @EnableAutoConfiguration / @SpringBootApplication is located.
// @EntityScan // Can be specified in a different class so that scanning starts there.
// @EnableJpaRepositories // No need to define this since all repositories will be auto detected from where the @EnableAutoConfiguration / @SpringBootApplication is located.
// @EnableAspectJAutoProxy // No need to define this since if aspect related jars are in the classpath then this annotation will be auto configured.
						   // Note that @EnableAspectJAutoProxy is per app context so if there a separate servlet web app context then a separate annotation is required if the other annotation is declared on the root context.
// @EnableTransactionManagement // No need to define this. Transaction will be auto configured.
//@ComponentScan({ "ph.mramos.vcps.section00", "ph.mramos.vcps.section09" }) // This explicitly overrides the internal @ComponentScan in @SpringBootApplication.
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
