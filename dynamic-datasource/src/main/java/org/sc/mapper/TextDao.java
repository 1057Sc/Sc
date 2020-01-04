package org.sc.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TextDao {

    @Select("select count(*) from test1")
    int test1();
}
