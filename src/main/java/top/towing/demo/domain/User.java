package top.towing.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column (name = "USER_NAME")
    private String userName;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "USER_TAGS",
        joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "TAG_ID", referencedColumnName = "ID"))
    private List<Tag> tags;
}
