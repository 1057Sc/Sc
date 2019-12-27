package org.sc.multidb;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

public class UseSqlSession extends SqlSessionDaoSupport {

    @Autowired
    private DataSource dataSource;

}
