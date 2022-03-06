package seeme.project.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class VFreeBoard {

    @Id
    private Long vFIdx;
    private String vFTitle;
    private String vFContent;

    private Long vFRCount = 0L;


    public VFreeBoard(String vFTitle, String vFContent) {
        this.vFTitle = vFTitle;
        this.vFContent = vFContent;
    }
}
