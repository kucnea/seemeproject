package seeme.project.domain.helpBoard;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class HelpBoardImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hBIIdx;

    private String hBFileOriName;
    private String hBFileUseName;
    private String hBFilePath;
    private Long hBFileSize;

    @ManyToOne
    @JoinColumn(name="hBIdx", referencedColumnName = "hBIdx")
    private HelpBoard helpBoard;

}
