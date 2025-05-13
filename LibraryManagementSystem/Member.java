package LibraryManagementSystem;

public class Member {
    int id;
    String name;
    Long phNo;

    public Member(int id, String name, Long phNo) {
        this.id = id;
        this.name = name;
        this.phNo = phNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhNo() {
        return phNo;
    }

    public void setPhNo(Long phNo) {
        this.phNo = phNo;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phNo=" + phNo +
                '}';
    }
}
