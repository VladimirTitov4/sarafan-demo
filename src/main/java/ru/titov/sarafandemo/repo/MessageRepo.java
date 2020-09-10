package ru.titov.sarafandemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.titov.sarafandemo.domain.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {

}
