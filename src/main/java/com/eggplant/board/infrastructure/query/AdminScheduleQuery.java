package com.eggplant.board.infrastructure.query;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class AdminScheduleQuery extends QuerydslRepositorySupport {

    private JPAQueryFactory jpaQueryFactory;

    public AdminScheduleQuery(JPAQueryFactory jpaQueryFactory) {
        super(AdminScheduleQuery.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
