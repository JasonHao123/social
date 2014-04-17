package jason.app.neo4j.dao;

import java.util.List;

import jason.app.neo4j.controller.DataInitializer;
import jason.app.neo4j.model.DBPerson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration("/test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PersonDaoTest {

	@Autowired
	private PersonDao personDao;

	@Autowired
	private DataInitializer dataInitializer;

	@Before
	public void prepareData() {
		dataInitializer.initData();
	}

	@Test
	public void shouldSaveAPerson() {
		DBPerson p = new DBPerson();
		p.setFirstName("Andy");
		p.setLastName("Gibson");
		personDao.save(p);
		Long id = p.getId();
		Assert.assertNotNull(id);
	}

	@Test
	public void shouldLoadAPerson() {
		Long template = dataInitializer.people.get(0);
		DBPerson p = personDao.find(template);

		Assert.assertNotNull("Person not found!", p);
		Assert.assertEquals(template, p.getId());
	}

	public void shouldListPeople() {
		List<DBPerson> people = personDao.getPeople();
		Assert.assertEquals(DataInitializer.PERSON_COUNT, people.size());

	}

}
