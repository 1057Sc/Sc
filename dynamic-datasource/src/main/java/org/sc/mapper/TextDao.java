package org.sc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TextDao {

    @Select("select count(*) from test")
    int test1();

    @Insert("insert into test (id,name,age) values ('3','zz','777')")
    int insertTest1();
}
