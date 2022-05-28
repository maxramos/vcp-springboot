package ph.mramos.vcps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Default entity scanning starts where the @EnableAutoConfiguration / @SpringBootApplication is located.
// @EntityScan // Can be specified in a different class to that scanning starts there.
// @EnableJpaRepositories // No need to define this since all repositories will be auto detected from where the @EnableAutoConfiguration / @SpringBootApplication is located.
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
