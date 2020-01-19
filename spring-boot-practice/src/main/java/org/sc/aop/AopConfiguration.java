package org.sc.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*@Configuration
@EnableAspectJAutoProxy*/
public class AopConfiguration {

    @Pointcut("execution(public String org.sc.aop.BusinessCode.getName(..))")
    public void pointCut(){}

    @Pointcut("execution(public int org.sc.aop.BusinessCode.reNumber(..))")
    public void myPointCut(){}

    @Bean
    public PerformanceMonitorInterceptor performanceMonitorInterceptor() {
        return new PerformanceMonitorInterceptor(true);
    }

    @Bean
    public Advisor performanceMonitorAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("org.sc.aop.AopConfiguration.pointCut()");
        return new DefaultPointcutAdvisor(pointcut, performanceMonitorInterceptor());
    }

    @Bean
    public MyPerformanceMonitorInterceptor myPerformanceMonitorInterceptor() {
        return new MyPerformanceMonitorInterceptor(true);
    }

    @Bean
    public Advisor advisor(){
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("org.sc.aop.AopConfiguration.myPointCut()");
        return new DefaultPointcutAdvisor(pointcut, myPerformanceMonitorInterceptor());
    }
}
