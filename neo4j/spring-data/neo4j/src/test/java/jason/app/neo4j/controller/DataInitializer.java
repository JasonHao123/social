package jason.app.neo4j.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jason.app.neo4j.model.DBPerson;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DataInitializer {

	public static final int PERSON_COUNT = 3;

	@PersistenceContext
	private EntityManager entityManager;

	public List<Long> people = new ArrayList<Long>();

	public void initData() {
		people.clear();// clear out the previous list of people
		addPerson("Jim", "Smith");
		addPerson("Tina", "Marsh");
		addPerson("Steve", "Blair");
		entityManager.flush();
		entityManager.clear();
	}

	public void addPerson(String firstName, String lastName) {
		DBPerson p = new DBPerson();
		p.setFirstName(firstName);
		p.setLastName(lastName);
		entityManager.persist(p);
		people.add(p.getId());
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
