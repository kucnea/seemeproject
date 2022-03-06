package seeme.project.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
@Table(name="VFREEBOARD")
public class VFreeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vFIdx;
    private String vFTitle;
    private String vFContent;

    private Long vFRCount = 0L;
    @Temporal(TemporalType.TIMESTAMP)
    private Date vFWDate = new Date();

    @ManyToOne
    @JoinColumn(name="vIdx", referencedColumnName = "vIdx")
    private Viewer viewer;

    public VFreeBoard(String vFTitle, String vFContent) {
        this.vFTitle = vFTitle;
        this.vFContent = vFContent;
    }
}
