package seeme.project.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class VFreeBoard {

    @Id
    private Long vFIdx;
    private String vFTitle;
    private String vFContent;

    private Long vFRCount = 0L;
    @Temporal(TemporalType.TIMESTAMP)
    private Date vFWDate = new Date();


    public VFreeBoard(String vFTitle, String vFContent) {
        this.vFTitle = vFTitle;
        this.vFContent = vFContent;
    }
}
