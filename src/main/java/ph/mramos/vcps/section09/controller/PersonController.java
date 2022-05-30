package ph.mramos.vcps.section09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ph.mramos.vcps.section09.entity.Person;
import ph.mramos.vcps.section09.webmvc.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Value("${info.app.java.version}")
	private String javaVersion;

	@Autowired
	private PersonService personService;

	@GetMapping("/{id}")
	public String find(@PathVariable int id, Model model) {
		Person person = personService.findById(id);
		model.addAttribute("person", person);
		model.addAttribute("javaVersion", javaVersion);
		return "person";
	}

}
