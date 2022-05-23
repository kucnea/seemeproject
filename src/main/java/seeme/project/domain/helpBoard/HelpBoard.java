package seeme.project.domain.helpBoard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seeme.project.domain.viewer.Viewer;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class HelpBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hBIdx;

    private String hBTitle;
    @Lob // String값이 길어질때 대비.
    private String hBContent;
    private Long hBCnt = 0l;

    @Temporal(TemporalType.TIMESTAMP)
    private Date hBTime = new Date();

    //referencedColumnName을 정함으로 정확한 Mapping을 하고 여러컬럼 join시에도 순서가 맞게됨.
    @ManyToOne
    @JoinColumn(name="vIdx", referencedColumnName = "vIdx")
    private Viewer viewer;

    @OneToMany(mappedBy = "helpBoard", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<HelpBoardComment> helpBoardComment;

    @OneToMany(mappedBy = "helpBoard", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<HelpBoardImg> helpBoardImg;

}
