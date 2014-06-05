package com.mks.hsqldemo;

import com.mks.hsqldemo.domain.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        new App().launch(args);
    }

    private void launch(String[] params) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class, DBConfig.class);
        ctx.refresh();

        Person p = new Person();
        p.setId(1);
        p.setFirstName(params[0]);
        p.setLastName(params[1]);

        PersonDao personDao = ctx.getBean(PersonDao.class);
        personDao.save(p);

        Person p1 = personDao.findOne(1L);

        System.out.println(p1.getFirstName() + " " + p1.getLastName());

        ctx.close();

    }
}
