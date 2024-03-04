package com.estsoft.hellospring.domain;

import org.junit.jupiter.api.Test;

class PersonTest {
    @Test
    void lombokTest() {
        Person person = new Person();
        person.setName("name");
        person.setAge(10);

        System.out.println(person.getName());
        System.out.println(person.getAge());
    }

}