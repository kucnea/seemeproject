package seeme.project.domain;

public class Viewer {

    private Long vIdx;
    private String vId;
    private String vPw;

    private int vStatus = 0; // 0 : 일반회원, 1 : 인증회원, 2 : 관리자, 3 : 최고관리자


    public Viewer() { }

    public Viewer(String vId, String vPw, int vStatus) {
        this.vId = vId;
        this.vPw = vPw;
        this.vStatus = vStatus;
    }

    public Long getvIdx() {
        return vIdx;
    }

    public void setvIdx(Long vIdx) {
        this.vIdx = vIdx;
    }

    public String getvId() {
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId;
    }

    public String getvPw() {
        return vPw;
    }

    public void setvPw(String vPw) {
        this.vPw = vPw;
    }

    public int getvStatus() {
        return vStatus;
    }

    public void setvStatus(int vStatus) {
        this.vStatus = vStatus;
    }
}
