package ph.mramos.vcps.section09.controller;

import static org.mockito.BDDMockito.given;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import ph.mramos.vcps.section09.entity.Person;
import ph.mramos.vcps.section09.service.PersonService;

@WebMvcTest(PersonController.class) // 'controllers' attribute can be left blank then only @Controller, @ControllerAdvice, and WebMvcConfigurer will be loaded from where @SpringBootApplication is located (including sub packages).
public class PersonControllerMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonService personService;

	@Test
	@WithMockUser // Can be annotated on the class.
	public void testStub_find() throws Exception {
		Person person = new Person("nikki1", "tan1", 35, Date.from(LocalDate.of(1986, 12, 25).atStartOfDay().toInstant(ZoneOffset.UTC)), 62.0, 157.48);
		given(personService.findById(1)).willReturn(person);

		mockMvc.perform(MockMvcRequestBuilders.get("/person/{id}", 1).accept(MediaType.APPLICATION_FORM_URLENCODED).secure(true))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("person"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("person"));
	}

}
