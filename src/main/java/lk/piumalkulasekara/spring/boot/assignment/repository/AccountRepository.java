package lk.piumalkulasekara.spring.boot.assignment.repository;

import lk.piumalkulasekara.spring.boot.assignment.model.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * @author piumalkulasekara
 * @version 1.0
 * @since 20/06/2019
 */
public interface AccountRepository extends CrudRepository<Account, Integer> {
}
