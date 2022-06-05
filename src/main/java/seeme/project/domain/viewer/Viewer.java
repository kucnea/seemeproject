package seeme.project.domain.viewer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import seeme.project.domain.helpBoard.HelpBoard;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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
    private Date vLoginDate;
//    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date vCreateTime;

    private String vStatus; // user : 일반회원, grantUser : 인증회원, manager : 관리자, admin : 최고관리자

    @OneToMany(mappedBy = "viewer", fetch = FetchType.EAGER)
    private Set<HelpBoard> helpBoard;


    //로그인용 생성자
    public Viewer(String vId, String vPw) {
        this.vId = vId;
        this.vPw = vPw;
    }

    //중복확인용 생성자
    public Viewer(String vId){
        this.vId = vId;
    }

    //테스트용 생성자
    public Viewer(String vId, String vPw, String vStatus) {
        this.vId = vId;
        this.vPw = vPw;
        this.vStatus = vStatus;
    }

}
