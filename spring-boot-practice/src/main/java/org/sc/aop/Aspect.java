package org.sc.aop;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Slf4j
@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    /**
     * aop pointcut
     */
    @Pointcut("execution(public * org.sc.*.*.*(..))")
    private void webLog(){
        System.out.println("I am pointcut");
    }

    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }


    @AfterReturning(returning = "ret", pointcut = "webLog()"    )
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        System.out.println("方法的返回值 : " + ret);
    }

    // 后置异常通知
    @AfterThrowing("webLog()")
    public void throwss(JoinPoint jp){
        System.out.println("方法异常时执行.....");
    }

    // 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("webLog()")
    public void after(JoinPoint jp){

        Object[] args = jp.getArgs();
        for (Object arg : args) {
            System.out.println(arg.getClass());
            if (arg instanceof Integer){
                System.out.println((Integer)arg);
            }
        }



        String s = JSONUtil.toJsonStr(jp);
        System.out.println(s);
        System.out.println("方法最后执行.....");
    }

    // 环绕通知,环绕增强，相当于MethodInterceptor 这个方法可以拿到方法的返回值
    @Around("webLog()")
    public Object arround(ProceedingJoinPoint pjp) {
        System.out.println("方法环绕start.....");
        try {
            Object o =  pjp.proceed();
            System.out.println("方法环绕proceed，结果是 :" + o);
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    public void afterReturn(Object returnValue) throws Throwable {
        log.info("value return was {}",  returnValue);
    }
}
