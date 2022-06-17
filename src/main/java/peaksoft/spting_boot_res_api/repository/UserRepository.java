package peaksoft.spting_boot_res_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.spting_boot_res_api.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}