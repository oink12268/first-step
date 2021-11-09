package com.eggplant.board.domain.match;

import com.eggplant.board.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}