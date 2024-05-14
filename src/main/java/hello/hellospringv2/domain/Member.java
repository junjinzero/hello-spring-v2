package hello.hellospringv2.domain;

public class Member {

    private Long id;
    private String name;

    // command + N 단축키로 한번에 게터세터
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
