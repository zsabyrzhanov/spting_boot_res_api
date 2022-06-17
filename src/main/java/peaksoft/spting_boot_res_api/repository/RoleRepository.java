package peaksoft.spting_boot_res_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.spting_boot_res_api.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(String roleName);
}