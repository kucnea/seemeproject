package seeme.project.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
@Setter
@Table(name="VIEWER")
public class Viewer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vIdx;
    private String vId;
    private String vPw;

    private int vStatus = 0; // 0 : 일반회원, 1 : 인증회원, 2 : 관리자, 3 : 최고관리자


    @OneToMany(mappedBy = "viewer", fetch = FetchType.EAGER)
    private Set<VFreeBoard> vFreeBoard;

    public Viewer(String vId, String vPw, int vStatus) {
        this.vId = vId;
        this.vPw = vPw;
        this.vStatus = vStatus;
    }

}
