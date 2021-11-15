package com.eggplant.board.domain.schedule.entity;

import com.eggplant.board.domain.court.entity.Court;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @OneToOne
    @JoinColumn(name = "court_idx", nullable = false)
    private Court court;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<UserSchedule> userSchedules = new ArrayList<>();

    @Builder
    public Schedule (Court court) {
        this.court = court;
    }

    public void addUserSchedule (UserSchedule userSchedules) {
        this.userSchedules.add(userSchedules);
    }
}
