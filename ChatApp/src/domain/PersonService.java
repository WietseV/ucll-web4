package domain;

import java.util.ArrayList;
import java.util.List;

import db.PersonRepository;
import db.PersonRepositoryStub;

public class PersonService {
	private PersonRepository personRepository = new PersonRepositoryStub();
	public List<ChatConv> Chatconvs = new ArrayList<>();

	public List<PraktijkExamen> praktijkExamens = new ArrayList<>();

	public List<PraktijkExamen> getPraktijkExamens() {
		return praktijkExamens;
	}

	public void addPraktijkExamen(PraktijkExamen pE) {
		praktijkExamens.add(pE);
	}

	public PersonService(){
	}
	
	public Person getPerson(String personId)  {
		return getPersonRepository().get(personId);
	}

	public List<Person> getPersons() {
		return getPersonRepository().getAll();
	}

	public void addPerson(Person person) {
		getPersonRepository().add(person);
	}

	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}

	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		return getPersonRepository().getAuthenticatedUser(email, password);
	}

	public void updateFirstName(String firstname, Person person){
		person.setFirstName(firstname);
		getPersonRepository().update(person);
	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}
}
