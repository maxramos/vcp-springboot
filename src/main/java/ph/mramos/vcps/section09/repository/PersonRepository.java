package ph.mramos.vcps.section09.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ph.mramos.vcps.section09.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	List<Person> findByFirstNameIgnoreCaseAndLastNameIgnoreCaseOrderByFirstNameDesc(String firstName, String lastName);

	List<Person> findFirst2ByLastNameIgnoreCaseOrderByFirstNameDesc(String lastName);

	@Query("SELECT p FROM Person p WHERE p.firstName LIKE :firstName") // ?1 can also be used instead of named paramater (1 based).
	List<Person> findByFirstNameOrderByFirstNameDesc(@Param("firstName") String firstName);

}
