package org.users.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.users.entity.Users;

@Repository
@Component
public interface UsersRepository extends JpaRepository<Users, Long> {

	List<Users> findByUsernameAndPassword(String username, String password);

	List<Users> findByEmail(String email);

	List<Users> findByAge(String age);

	List<Users> findByUsername(String username);

}
