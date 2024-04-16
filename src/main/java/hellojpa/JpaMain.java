package hellojpa;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            //========= 저장로직 ===============
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//
//            em.persist(member); //저장
            //=================================

//            //========= 수정로직 ===============
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());
//            findMember.setName("HelloJPA");
//            //변경하면 JPA가 객체를 관리하면서 수정된게 있으면 update쿼리 알아서 날림
//
//            // =====================================
//
//            //========= 삭제로직 ===============
//            Member findMember2 = em.find(Member.class, 1L);
//            em.remove(findMember2);
            // =====================================

            //전체 회원 조회
            //JPA의 쿼리 대상은 테이블이 아님!! 객체임
            //이게 JPQL (객체지향 SQL)
            List<Member> memberList = em.createQuery("select m from Member as m", Member.class)
                                      .getResultList();

            for (Member listMember : memberList) {
                System.out.println("listMember.getName() = " + listMember.getName());

            }

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
