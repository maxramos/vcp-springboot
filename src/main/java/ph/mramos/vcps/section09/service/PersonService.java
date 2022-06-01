package ph.mramos.vcps.section09.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ph.mramos.vcps.section09.entity.Person;
import ph.mramos.vcps.section09.repository.PersonRepository;

@Service
@Transactional // Be careful to import org.springframework.transaction.annotation.Transactional and NOT javax.transaction.Transactional otherwise there will be errors.
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Person findById(int id) {
//		Person person = personRepository.getById(id); // causes "Hibernate could not initialize proxy – no Session" if fields are not all fetch before the transaction ends.
//		System.out.println(person);
		Optional<Person> result = personRepository.findById(id);
		return result.orElseThrow(PersonIdNotFoundException::new);
	}

	public Person findByFirstName(String firstName) {
		Person p = new Person();
		p.setFirstName(firstName);

		Example<Person> example = Example.of(p, ExampleMatcher.matchingAny().withIgnoreCase());

		Optional<Person> result = personRepository.findOne(example);

		if (result.isPresent()) {
			Person person = result.get();
			System.out.println(person); // Must first load the fields from the database to prevent the error: "Hibernate could not initialize proxy – no Session".
			return person;
		}

		throw new RuntimeException("Person not found.");
	}

}
