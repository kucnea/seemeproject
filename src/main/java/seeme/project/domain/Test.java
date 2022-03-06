package seeme.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="TEST")
@SequenceGenerator(						// 오라클 사용시
        name = "TEST_SEQ_GENERATOR",
        sequenceName = "TEST_SEQ",
        initialValue = 1, allocationSize = 50)
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Test {

    @Id
    private Long tIdx;
    private String tName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date tDate = new Date();
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEST_SEQ_GENERATOR")
    private Long tsubIdx;

}
