package com.eggplant.board.domain.schedule.entity;

import com.eggplant.board.domain.user.entity.User;

import javax.persistence.*;

@Entity
public class UserSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "schedule_idx", nullable = false)
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "user_idx", nullable = false)
    private User user;
}
