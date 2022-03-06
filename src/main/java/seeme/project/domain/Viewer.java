package seeme.project.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
@Setter
public class Viewer {

    @Id
    private Long vIdx;
    private String vId;
    private String vPw;

    private int vStatus = 0; // 0 : 일반회원, 1 : 인증회원, 2 : 관리자, 3 : 최고관리자


    public Viewer(String vId, String vPw, int vStatus) {
        this.vId = vId;
        this.vPw = vPw;
        this.vStatus = vStatus;
    }

}
