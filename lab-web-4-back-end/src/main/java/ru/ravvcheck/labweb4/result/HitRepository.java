package ru.ravvcheck.labweb4.result;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HitRepository extends JpaRepository<Hit, Long> {
    List<Hit> getHitByOwner(String owner);

    void deleteHitsByOwner(String owner);
}
