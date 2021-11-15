package com.eggplant.board.application.admin;

import com.eggplant.board.application.ScheduleMapper;
import com.eggplant.board.domain.schedule.ScheduleRepository;
import com.eggplant.board.domain.schedule.entity.Schedule;
import com.eggplant.board.domain.user.UserRepository;
import com.eggplant.board.domain.user.entity.User;
import com.eggplant.board.presentation.dto.ScheduleDto;
import com.eggplant.board.presentation.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;

    @Transactional
    public Long addSchedule(ScheduleDto scheduleDto) {
        Schedule schedule = scheduleMapper.mapFrom(scheduleDto);

        scheduleRepository.save(schedule);

        return schedule.getIdx();
    }
}
