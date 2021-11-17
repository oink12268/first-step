package com.eggplant.board.presentation.vo;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

import java.util.List;

@Getter
public class ScheduleVo {

    private Long scheduleIdx;

    private String courtName;

    private List<UserVo> userList;

    public void setUserList(List<UserVo> userList) {
        this.userList = userList;
    }
}
