package seeme.project.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.concurrent.atomic.AtomicLong;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Viewer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vIdx;
    private String vId;
    private String vPw;
    private String vName;
    private int vGender; // 0 : 남자, 1 : 여자
    private int vType; // 0 : 뷰어, 1 : 헬퍼

    private int vStatus = 0; // 0 : 일반회원, 1 : 인증회원, 2 : 관리자, 3 : 최고관리자

    //테스트용 생성자
    public Viewer(String vId, String vPw, int vStatus) {
        this.vId = vId;
        this.vPw = vPw;
        this.vStatus = vStatus;
    }

}
