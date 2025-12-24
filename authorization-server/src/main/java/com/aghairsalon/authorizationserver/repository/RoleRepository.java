package com.aghairsalon.authorizationserver.repository;

import com.aghairsalon.authorizationserver.entity.Role;
import com.aghairsalon.authorizationserver.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRole(RoleName roleName);

}
