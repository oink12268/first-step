package com.eggplant.board.presentation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ScheduleDto {

    private Long courtIdx;

    private List<Long> userIds;
}
