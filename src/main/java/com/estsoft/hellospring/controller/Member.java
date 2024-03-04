package com.estsoft.hellospring.controller;


import jakarta.persistence.*;

@Entity
public class Member { //DB
    // 이 아이는 이제...DAO(repository)가 됩니다..
//    private Long id;
//    private String name;
//    private String phone;

    //insert into member (name)values("이름"); id: 1, name: 이름
    //insert into member (name)values("이름2"); id: 2,, name: 이름2
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id; //DB 테이블의 id와 컬럼 매칭

    @Column(name="name", nullable = false)
    private String name; // DB 테이블의 name과 컬럼 매칭
}
