package spring.soa.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.soa.web.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
