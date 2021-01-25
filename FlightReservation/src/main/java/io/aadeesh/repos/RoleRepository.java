package io.aadeesh.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import io.aadeesh.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
