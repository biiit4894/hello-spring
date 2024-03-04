package com.estsoft.hellospring.repository;

import com.estsoft.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//JPA
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
