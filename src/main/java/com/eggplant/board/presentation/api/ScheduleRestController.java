package com.eggplant.board.presentation.api;

import com.eggplant.board.application.admin.ScheduleService;
import com.eggplant.board.domain.schedule.ScheduleRepository;
import com.eggplant.board.presentation.dto.ScheduleDto;
import com.eggplant.board.presentation.vo.ScheduleVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequiredArgsConstructor
@ResponseBody
public class ScheduleRestController {

    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;

    @PostMapping("/schedule")
    public void addSchedule (@RequestBody ScheduleDto scheduleDto) {
        scheduleService.addSchedule(scheduleDto);
    }

    @GetMapping("/schedule")
    public ResponseEntity<List<ScheduleVo>> findSchedule() {
        scheduleRepository.findSchedule();

    }
}
