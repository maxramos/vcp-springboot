package ph.mramos.vcps.section09.webmvc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Value("${app.java.version}")
	private String javaVersion;

	@GetMapping("/{id}")
		public String find(@PathVariable int id, Model model) {
			model.addAttribute("id", id);
			model.addAttribute("javaVersion", javaVersion);
			return "person";
		}

}
