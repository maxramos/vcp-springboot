package ph.mramos.vcps.section00;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class SampleComponent {

	@PostConstruct
	private void init() {
		System.out.println("SampleComponent#init");
	}

	public void run() {
		System.out.println("SampleComponent#run");
	}

}
