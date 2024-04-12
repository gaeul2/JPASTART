package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity//JPA를 사용하는 애구나
public class Member {
    @Id//이게 pk다.
    private Long id;
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
