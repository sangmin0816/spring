package kr.co.teaspoon.test;

import kr.co.teaspoon.dto.Person;
import org.springframework.context.support.GenericXmlApplicationContext;

public class IoCTest {
    public static void main(String[] args) {
        GenericXmlApplicationContext factory;
        factory = new GenericXmlApplicationContext("GenericXmlApplicationContext.xml");
        Person person = (Person) factory.getBean("person");
        System.out.println(person.getSample().toString());
        System.out.println(person.getTel());
    }
}

