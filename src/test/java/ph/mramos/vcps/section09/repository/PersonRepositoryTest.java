package ph.mramos.vcps.section09.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import ph.mramos.vcps.section09.entity.Person;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE) // If actual database connection is wanted. Uncomment MySQL configs in application.properties and MySQL dirver dependency in pom.
public class PersonRepositoryTest {

	@Autowired
	private TestEntityManager em;

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void test_findById() {
		Optional<Person> result = personRepository.findById(1);
		Person person  = result.get();

		assertThat(person.getFirstName()).isEqualTo("max");
		System.out.println(person);
	}

	@Test
	public void test_findByName() {
		Person person = new Person(" therese", "ramos", 35, Date.from(LocalDate.of(1986, 12, 25).atStartOfDay().toInstant(ZoneOffset.UTC)), 62, 157.48);
		em.persist(person);

		List<Person> persons = personRepository.findFirst2ByLastNameIgnoreCaseOrderByFirstNameDesc("ramos");

		assertThat(persons.size()).isEqualTo(2);
		persons.forEach(System.out::println);
	}

}
