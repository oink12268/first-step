package com.eggplant.board.domain.court;

import com.eggplant.board.domain.court.entity.Court;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtRepository extends JpaRepository<Court, Long> {
}
