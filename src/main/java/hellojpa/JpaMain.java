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
//            List<Member> memberList = em.createQuery("select m from Member as m", Member.class)
//                                      .getResultList();
//
//            for (Member listMember : memberList) {
//                System.out.println("listMember.getName() = " + listMember.getName());
//
//            }

            /*
            영속성 설명
             */
//            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            //영속
//            System.out.println("=========BEFORE============");
//            em.persist(member); //얘가 저장이라고 했지만 아님. 그냥 영속상태를 만들어주는것.
//            System.out.println("==========AFTER============");

//            Member findMember = em.find(Member.class, 101L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L); //영속성 컨텍스트에 있는 1차캐시에 있는것을 들고옴

//            //영속 엔티티의 동일성 보장
//            Member a = em.find(Member.class, 101L);
//            Member b = em.find(Member.class, 101L);
//            System.out.println("result = " + (a==b));

//              //쿼리를 모아서 보냄
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("============================");

            //변경확인
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZZ");
//            System.out.println("============================");

            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZZ");
            if (member.getName().equals("ZZZZZZ")){
                em.persist(member);
            }

            tx.commit(); // 이때 영속상태에 있는 것이 커밋을 통해 저장되는것.
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
