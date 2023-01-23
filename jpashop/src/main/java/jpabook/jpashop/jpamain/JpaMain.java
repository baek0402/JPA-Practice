package jpabook.jpashop.jpamain;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //db랑 연결도 된거야.

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx. begin();

        try {
            /*
            Order order = em.find(Order.class, 1L);
            Long memberId = order.getMemberId();

            Member member = em.find(Member.class, memberId);
            이렇게 거쳐거쳐 가게돼.. 객체지향적이지못해
            */

            /* 하단식으로 해야지
            Member findMember = order.getMember();
            findMMember.getId();
            */

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
