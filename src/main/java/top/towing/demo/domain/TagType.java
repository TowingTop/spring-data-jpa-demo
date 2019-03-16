package top.towing.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TAG_TYPES")
public class TagType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TAG_TYPE")
    private String tagType;

    //@OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, mappedBy = "tagType")
    //private List<Tag> tags;
}
