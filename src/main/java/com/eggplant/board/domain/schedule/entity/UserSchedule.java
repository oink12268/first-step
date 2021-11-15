package com.eggplant.board.domain.schedule.entity;

import com.eggplant.board.domain.user.entity.User;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@RequiredArgsConstructor
@Entity
public class UserSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_idx", nullable = false)
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "user_idx", nullable = false)
    private User user;

    @Builder
    public UserSchedule (Schedule schedule, User user) {
        this.schedule = schedule;
        this.user = user;
    }
}
