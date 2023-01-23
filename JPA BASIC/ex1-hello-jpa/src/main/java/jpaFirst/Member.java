package jpaFirst;

import javax.persistence.*;
import java.util.Date;

@Entity //이걸 넣어야 JPA가 처음 로딩될때 JPA 사용하는 애라는 걸 인식하니까
public class Member {
    @Id
    private Long id;
    @Column(name = "name")
    private String username;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    @Lob
    private String description;

    public Member() {

    }
}
