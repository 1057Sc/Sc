package org.sc.multidb;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Proxy;

/**
 * @author sc
 * @date 2021/5/29
 */
@Intercepts({
        @Signature(
                type = Executor.class,
                method = "update",
                args = {MappedStatement.class, Object.class}),
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
})
public class SqlPlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        Configuration configuration = mappedStatement.getConfiguration();
        if (args.length > 1) {
            Object param = args[1];
            BoundSql boundSql = mappedStatement.getBoundSql(param);
            String replace1 = boundSql.getSql().replace("test_table", "test_table_copy1");
            // modify sql
            MetaObject metaObject = configuration.newMetaObject(boundSql);
            metaObject.setValue("sql", replace1);

            // inject sql
            MetaObject metaObject1 = configuration.newMetaObject(mappedStatement);
            metaObject1.setValue("sqlSource.sqlSource.sql", replace1);
            System.out.println(123);
        }
        Object param = args[1];
        BoundSql boundSql = mappedStatement.getBoundSql(param);
        System.out.println(boundSql.getSql());
        return invocation.proceed();
    }

    public static <T> T realTarget(Object target) {
        if (Proxy.isProxyClass(target.getClass())) {
            MetaObject metaObject = SystemMetaObject.forObject(target);
            return realTarget(metaObject.getValue("h.target"));
        }
        return (T) target;
    }

}
