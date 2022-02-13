package seeme.project.domain;

public class VFreeBoard {

    private Long vFIdx;
    private String vFTitle;
    private String vFContent;

    private Long vFRCount = 0L;



    public VFreeBoard() { }

    public VFreeBoard(String vFTitle, String vFContent) {
        this.vFTitle = vFTitle;
        this.vFContent = vFContent;
    }

    public Long getvFIdx() {
        return vFIdx;
    }

    public void setvFIdx(Long vFIdx) {
        this.vFIdx = vFIdx;
    }

    public String getvFTitle() {
        return vFTitle;
    }

    public void setvFTitle(String vFTitle) {
        this.vFTitle = vFTitle;
    }

    public String getvFContent() {
        return vFContent;
    }

    public void setvFContent(String vFContent) {
        this.vFContent = vFContent;
    }

    public Long getvFRCount() {
        return vFRCount;
    }

    public void setvFRCount(Long vFRCount) {
        this.vFRCount = vFRCount;
    }
}
