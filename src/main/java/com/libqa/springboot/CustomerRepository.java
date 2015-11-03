package com.libqa.springboot;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Created by sujinee on 15. 10. 20..
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	List<Customer> findByLastName(String lastName);
}
