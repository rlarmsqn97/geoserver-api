package jbt.boo.some.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerfAspect {

    @After("execution(* jbt.boo.some.aop.Test.*(..))")
    public void sout() {
        System.out.println("하하");
    }
}
