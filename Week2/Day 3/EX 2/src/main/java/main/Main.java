package main;

import config.ProjectConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.ServiceAOP;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        ServiceAOP saop = context.getBean(ServiceAOP.class);
        saop.testfunction();

    }
}
