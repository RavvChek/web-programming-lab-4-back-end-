package ru.ravvcheck.labweb4.user;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByLogin(@NonNull String login);
}
