package program.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Dortmitory")
public class Dormitory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int")
    private int id;

    @Column(name = "name_dormitory", columnDefinition = "VARCHAR(20)", nullable = false)
    private String nameDormitory;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dormitory")
    private List<Block> blocks;
}
