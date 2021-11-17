package com.eggplant.board.presentation.api;

import com.eggplant.board.application.admin.ScheduleService;
import com.eggplant.board.domain.schedule.ScheduleRepository;
import com.eggplant.board.infrastructure.query.AdminScheduleQuery;
import com.eggplant.board.infrastructure.query.AdminUserQuery;
import com.eggplant.board.presentation.dto.ScheduleDto;
import com.eggplant.board.presentation.vo.ScheduleVo;
import com.eggplant.board.presentation.vo.UserVo;
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
    private final AdminScheduleQuery adminScheduleQuery;
    private final AdminUserQuery adminUserQuery;

    @PostMapping("/schedule")
    public void addSchedule (@RequestBody ScheduleDto scheduleDto) {
        scheduleService.addSchedule(scheduleDto);
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleVo>> findSchedule() {
        List<ScheduleVo> scheduleVoList = adminScheduleQuery.findScheduleList();

        for (ScheduleVo scheduleVo : scheduleVoList) {
            List<UserVo> userVoList = adminUserQuery.findUserList(scheduleVo.getScheduleIdx());
            scheduleVo.setUserList(userVoList);
        }

        return ResponseEntity.ok().body(scheduleVoList);
    }
}
