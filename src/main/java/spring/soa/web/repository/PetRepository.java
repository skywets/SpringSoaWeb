package spring.soa.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.soa.web.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
