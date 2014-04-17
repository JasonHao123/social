package jason.app.neo4j.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jason.app.neo4j.model.DBPerson;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PersonDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public DBPerson find(Long id) {
		return entityManager.find(DBPerson.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<DBPerson> getPeople() {
		return entityManager.createQuery("select p from Person p").getResultList();
	}
	
	@Transactional
	public DBPerson save(DBPerson person) {
		if (person.getId() == null) {
			entityManager.persist(person);
			return person;
		} else {
			return entityManager.merge(person);
		}		
	}	
	
}
