package com.eggplant.board.infrastructure.query;

import com.eggplant.board.presentation.vo.UserVo;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.eggplant.board.domain.schedule.entity.QUserSchedule.userSchedule;
import static com.eggplant.board.domain.user.entity.QUser.user;

@Repository
public class AdminUserQuery extends QuerydslRepositorySupport {

    private JPAQueryFactory jpaQueryFactory;


    public AdminUserQuery(JPAQueryFactory jpaQueryFactory) {
        super(AdminUserQuery.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<UserVo> findUserList (Long scheduleIdx) {
        JPAQuery query =  jpaQueryFactory.select(Projections.fields(UserVo.class,
                user.userName
        ))
                .from(user)
                .innerJoin(userSchedule).on(userSchedule.user.idx.eq(user.idx))
                .where(userSchedule.schedule.idx.eq(scheduleIdx));

        return query.fetch();
    }

}
