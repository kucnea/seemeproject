package seeme.project.domain.helpBoard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seeme.project.domain.viewer.Viewer;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class HelpBoardComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hBCIdx;

    private String hBComment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date hBCTime = new Date();

    @ManyToOne
    @JoinColumn(name="HBIdx", referencedColumnName = "HBIdx")
    private HelpBoard helpBoard;

    @ManyToOne
    @JoinColumn(name="vIdx", referencedColumnName = "vIdx")
    private Viewer viewer;

}
