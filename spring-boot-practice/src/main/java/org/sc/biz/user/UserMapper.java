package org.sc.biz.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectFoo(String  name);

    long fooAdd(String name);

    long fooUpdate(long id);

    long fooDelete(long id);
}
