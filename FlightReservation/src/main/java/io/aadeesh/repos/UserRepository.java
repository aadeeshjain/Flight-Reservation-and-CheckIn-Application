package io.aadeesh.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import io.aadeesh.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

}
