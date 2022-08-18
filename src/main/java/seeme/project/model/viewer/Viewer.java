package seeme.project.model.viewer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seeme.project.entity.viewer.ViewerEntity;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class Viewer {

    private Long vIdx;
    private String vId;
    private String vPw;
    private String vNick;
    private Date vLoginDate;
    //    @Temporal(TemporalType.TIMESTAMP)
    private Date vCreateTime;

    private String vStatus; // user : 일반회원, grantUser : 인증회원, manager : 관리자, admin : 최고관리자


    public Viewer (String vId, String vNick, String vStatus){
        this.vId = vId;
        this.vNick = vNick;
        this.vStatus = vStatus;
    }

    public static Viewer from(ViewerEntity viewerEntity){
        return new Viewer(viewerEntity.getVId(), viewerEntity.getVNick(), viewerEntity.getVStatus());
    }

}
