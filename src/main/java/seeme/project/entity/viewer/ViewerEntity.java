package seeme.project.entity.viewer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class ViewerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long VIdx;
    private String VId;
    private String VPw;
    private String VNick;
    private Date VLoginDate;
//    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date VCreateTime;

    private String VStatus; // user : 일반회원, grantUser : 인증회원, manager : 관리자, admin : 최고관리자
    private String vDeleteYN;

//    @OneToMany(mappedBy = "viewer", fetch = FetchType.EAGER)
//    private Set<HelpBoard> helpBoard;


    //로그인용 생성자
    public ViewerEntity(String vId, String vPw) {
        this.VId = vId;
        this.VPw = vPw;
    }

    //중복확인용 생성자
    public ViewerEntity(String vId){
        this.VId = vId;
    }

    //테스트용 생성자
    public ViewerEntity(String vId, String vPw, String vStatus) {
        this.VId = vId;
        this.VPw = vPw;
        this.VStatus = vStatus;
    }

}
