package seeme.project.config.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private String vId;
    private String vNick;
    private List<String> vStatus;

    public JwtResponse(String accessToken, String vId, String vNick, List<String> vStatus) {
        this.token = accessToken;
        this.vId = vId;
        this.vNick = vNick;
        this.vStatus = vStatus;
    }

}
