package program.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Dortmitory")
@Getter
@Setter
public class Dormitory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    @Column(name = "name_dormitory", columnDefinition = "VARCHAR(20)", nullable = false)
    private String nameDormitory;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dormitory")
    private Set<Block> blocks = new HashSet<>();
}
