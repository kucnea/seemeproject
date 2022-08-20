package seeme.project.dto.viewer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import seeme.project.entity.viewer.ViewerEntity;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class ViewerLoginDto {

    private String vId;
    private String vPw;
    private String vNick;
    private String vStatus; // user : 일반회원, grantUser : 인증회원, manager : 관리자, admin : 최고관리자


    public ViewerLoginDto(String vId, String vNick, String vStatus){
        this.vId = vId;
        this.vNick = vNick;
        this.vStatus = vStatus;
    }

    public static ViewerLoginDto from(ViewerEntity viewerEntity){
        return new ViewerLoginDto(viewerEntity.getVId(), viewerEntity.getVNick(), viewerEntity.getVStatus());
    }

}
