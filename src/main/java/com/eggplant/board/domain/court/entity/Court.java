package com.eggplant.board.domain.court.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    /**
     * 코트명
     */
    @Column(name = "name", nullable = false, length = 200)
    private String name;

    /**
     * 전화번호
     */
    @Column(name = "phone", length = 200)
    private String phone;
}
