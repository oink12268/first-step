package com.eggplant.board.application;

import com.eggplant.board.domain.court.CourtRepository;
import com.eggplant.board.domain.court.entity.Court;
import com.eggplant.board.domain.schedule.ScheduleRepository;
import com.eggplant.board.domain.schedule.entity.Schedule;
import com.eggplant.board.domain.schedule.entity.UserSchedule;
import com.eggplant.board.domain.user.UserRepository;
import com.eggplant.board.domain.user.entity.User;
import com.eggplant.board.presentation.dto.ScheduleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ScheduleMapper {

    private final CourtRepository courtRepository;
    private final UserRepository userRepository;

    public Schedule mapFrom (ScheduleDto scheduleDto) {
        Schedule schedule = Schedule.builder()
                .court(this.getCourt(scheduleDto.getCourtIdx()))
                .build();

//        scheduleDto.getUserIds().forEach(userIdx -> {
//            User user = userRepository.findById(userIdx).get();
//            schedule.addUserSchedule(UserSchedule.builder().user(user).schedule(schedule).build());
//        });
        for(Long userIdx : scheduleDto.getUserIds()) {
            User user = userRepository.findById(userIdx).get();
            UserSchedule userSchedule = UserSchedule.builder().user(user).schedule(schedule).build();
            schedule.addUserSchedule(userSchedule);
        }

        return schedule;
    }

    public Court getCourt (Long courtIdx) {
        Court court = courtRepository.findById(courtIdx).get();

        return court;
    }
}
