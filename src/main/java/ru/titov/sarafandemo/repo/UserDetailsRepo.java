package ru.titov.sarafandemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.titov.sarafandemo.domain.User;

public interface UserDetailsRepo extends JpaRepository<User, String> {
}
