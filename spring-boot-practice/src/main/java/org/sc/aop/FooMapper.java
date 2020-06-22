package org.sc.aop;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FooMapper {

    FooEntity selectFoo(int id);

    void fooAdd(String name);
}
