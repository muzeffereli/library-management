package az.muzeffereli.library.management.repository;

import az.muzeffereli.library.management.dao.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
