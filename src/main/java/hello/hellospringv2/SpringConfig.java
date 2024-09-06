package hello.hellospringv2;

import hello.hellospringv2.repository.*;
import hello.hellospringv2.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    // bean 을 내가 등록할거야.
//    // configuration 을 스프링이 뜰 때 읽고, 이건 스프링빈에 등록해야되는 거네? 하고 인식을 함 -> memberService 를 읽고 스프링빈에 등록해서 호출함.
//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    // 이 memberRepository 를 엮어다가 위에 있는 멤버 서비스를 띄운다.
    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
