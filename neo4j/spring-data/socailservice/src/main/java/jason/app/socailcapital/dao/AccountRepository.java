package jason.app.socailcapital.dao;

import jason.app.socailcapital.entity.Account;
import jason.app.socailcapital.entity.Customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Repository to manage {@link Account} instances.
 * 
 * @author Oliver Gierke
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

	/**
	 * Returns all accounts belonging to the given {@link Customer}.
	 * 
	 * @param customer
	 * @return
	 */
	List<Account> findByCustomer(Customer customer);
}
