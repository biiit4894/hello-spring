package com.estsoft.hellospring.domain;

import org.junit.Test;

public class PersonTest {
    @Test
    public void test() {
        Person person = new Person();
        person.setName("Anything");
        person.setAge(20);

        person.getName();
        person.getAge();
    }
}
