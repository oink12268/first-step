package com.eggplant.board.infrastructure.query;

import com.eggplant.board.presentation.vo.ScheduleVo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.eggplant.board.domain.schedule.entity.QSchedule.schedule;
import static com.eggplant.board.domain.court.entity.QCourt.court;

@Repository
public class AdminScheduleQuery extends QuerydslRepositorySupport {

    private JPAQueryFactory jpaQueryFactory;

    public AdminScheduleQuery(JPAQueryFactory jpaQueryFactory) {
        super(AdminScheduleQuery.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<ScheduleVo> findScheduleList () {
        return jpaQueryFactory.select(Projections.fields(ScheduleVo.class,
                    schedule.idx.as("scheduleIdx"),
                    court.name.as("courtName")
                ))
                .from(schedule)
                .innerJoin(schedule.court, court)
                .fetch();
    }
}
