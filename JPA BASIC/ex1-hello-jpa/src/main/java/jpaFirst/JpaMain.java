package jpaFirst;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //db랑 연결도 된거야.
        //얘는 최초 1회고

        EntityManager em = emf.createEntityManager();
        //트랜잭션 단위를 할 때는 db 커낵션 얻고, 쿼리 날리고 종료하기위한 manager을 매번 작성해줘야해

        //(2)
        EntityTransaction tx = em.getTransaction();
        tx. begin();

        //(3)
        try {
            /**
            //실제 동작 코드 작성
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");
            em.persist(member);
            //여기까지만 해도 안돼..
            //왜냐, transaction이 필요하거든! (2)

            //1. 찾기
            Member findMember = em.find(Member.class, 1L);
            System.out.println("find member id : " + findMember.getId());

            //2. 삭제
            em.remove(findMember); //delete query

            //3. 수정
            findMember.setName("helloA2B");
            //방금찾은멤버 저장해야하는거아닌가요? em.persist(findMember);
            //NONO!

            // (3) JPQL
            //table 대상이 아닌 Member 객체를 대상으로 쿼리를 하는거임
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    //.setFirstResult(8);
                    //.setMaxResult(7);
                    .getResultList();

            for(Member m : result) {
                System.out.println("m.name = " + m.getName());
            }
            **/
            //(2)
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        // 동작 후 h2 db select .. 해주면 데이터가 저장된걸 알 수있지
        // JPA가 매핑정보를 보고 해준거야~!

        //em.close();
        emf.close(); //실제 appli가 완전히 끝나면 factory 닫아줘.

        //이제 table 만들어볼게~
    }
}
