package com.eggplant.board.domain.match.Match;

import com.eggplant.board.domain.court.entity.Court;
import com.eggplant.board.domain.user.entity.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @OneToOne
    @JoinColumn(name = "court_idx", nullable = false)
    private Court court;

    @OneToMany()
    private List<User> user;
}
