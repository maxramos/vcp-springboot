package ph.mramos.vcps.section09;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ph.mramos.vcps.section00.SampleComponent;
import ph.mramos.vcps.section09.service.PersonService;

@SpringBootTest
public class ComponentScanTest {

	@Autowired
	private SampleComponent sampleComponent;

	@Autowired
	private PersonService personService;

	@Test // This will fail since explicitly specifying @ComponentScan overrides the internal @ComponentScan in @SpringBootApplication unless all required packages are declared in the specified @ComponentScan.
	public void test_find() throws Exception {
		sampleComponent.run();
		personService.run();
	}

}
