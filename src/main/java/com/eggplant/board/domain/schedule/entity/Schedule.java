package com.eggplant.board.domain.schedule.entity;

import com.eggplant.board.domain.court.entity.Court;

import javax.persistence.*;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @OneToOne
    @JoinColumn(name = "court_idx", nullable = false)
    private Court court;
}
