package hellojpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity//JPA를 사용하는 애구나
//@Table(name = "Member") //테이블명 다르다면 이렇게 지정도 할 수 있음
public class Member {
    @Id//이게 pk다.
    private Long id;
//    @Column(name = "username") // 컬럼명이 다르다면 이렇게 지정가능
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
