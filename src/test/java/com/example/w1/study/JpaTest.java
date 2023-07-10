package com.example.w1.study;

import com.example.w1.study.entity.Memo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

public class JpaTest {
    EntityManagerFactory emf;
    EntityManager em;

    @BeforeEach
    void setUp() {
        emf = Persistence.createEntityManagerFactory("memo");
        em = emf.createEntityManager();
    }

    @Test
    @DisplayName("tt")
    void jpaTest() {
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            Memo memo = new Memo();
//            Memo memo = em.find(Memo.class, 3L);
            memo.setId(3L);
            memo.setContents("11");
            memo.setUsername("~571");
//            em.detach(memo);
            em.persist(memo);
            System.out.println(em.contains(memo));
//            em.merge(memo);

//            memo.setId(2L);
//            memo.setContents("113");
//            memo.setUsername("choi22");
//            em.merge(memo);

            et.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            et.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    @Test
    @Transactional
    @Rollback(value = false)
    @DisplayName("tt2")
    void t2(){
        Memo memo = new Memo();
        memo.setId(2L);
        memo.setContents("112");
        memo.setUsername("choi2");
        em.merge(memo);
    }
}
