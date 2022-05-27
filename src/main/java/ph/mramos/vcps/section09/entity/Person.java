package ph.mramos.vcps.section09.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	private int age;

	@Temporal(TemporalType.DATE)
	@Column
	private Date birthDate;

	private double weight;

	private double height;

	public Person() {
		super();
	}

	public Person(String firstName, String lastName, int age, Date birthDate, double weight, double height) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.birthDate = birthDate;
		this.weight = weight;
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return String.format("Person [id=%s, firstName=%s, lastName=%s, age=%s, birthDate=%s, weight=%s, height=%s]", id, firstName, lastName, age, birthDate, weight, height);
	}

}
