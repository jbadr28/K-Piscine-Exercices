package service;

import aspect.Timelt;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
public class ServiceAOP {

    @Timelt
    public void testfunction() {

        System.out.println("doing absolument nothing");

    }
}
