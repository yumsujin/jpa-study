package com.libqa.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sujinee on 15. 10. 28..
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
	List<Member> findByName(String name);
}
