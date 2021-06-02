package org.sc.aop;

import org.apache.ibatis.annotations.Mapper;
import org.sc.config.FooEntity;

@Mapper
public interface FooMapper {

    FooEntity selectFoo(int id);

    void fooAdd(String name);

    void fooUpdate();
}
