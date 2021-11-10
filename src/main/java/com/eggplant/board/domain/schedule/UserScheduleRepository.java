package com.eggplant.board.domain.schedule;

import com.eggplant.board.domain.schedule.entity.UserSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserScheduleRepository extends JpaRepository<UserSchedule, Long> {
}