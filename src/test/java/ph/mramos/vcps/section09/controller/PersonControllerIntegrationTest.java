package ph.mramos.vcps.section09.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc // Needed if not running the slice @WebMvcTest
public class PersonControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@WithMockUser // Can be annotated on the class.
	public void test_find1() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/person/{id}", 1).accept(MediaType.APPLICATION_FORM_URLENCODED).secure(true))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("person"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("person"));
	}

	@Test
	@WithUserDetails // If annotated in the class then it must be specified as @WithUserDetails(setupBefore = TestExecutionEvent.TEST_EXECUTION)
	public void test_find2() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/person/{id}", 1).accept(MediaType.APPLICATION_FORM_URLENCODED).secure(true))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("person"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("person"));
	}

}
