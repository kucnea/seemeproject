package seeme.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import seeme.project.domain.viewer.Viewer;
import seeme.project.service.ViewerService;

@RestController // Json 형식을 리턴하는 Controller
@Slf4j
@RequestMapping("/viewer")
public class ViewerRestController {

    // 생성자 주입
    private final ViewerService viewerService;

    // 스프링 컨테이너에 등록하면 하나만 넣어 쓸 수 있음, 다른 이점도 있음
    @Autowired
    public ViewerRestController(ViewerService viewerService){ // 이대로만 쓰면, service를 spring이 알 수 없음.
        this.viewerService = viewerService;               // ViewerService에 @Service 추가
    }

//    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;


    /*
    @PostMapping("/viewerjoin.do")
    public Object viewerJoin(@RequestBody Viewer viewer) {
        log.info("● ● ● Into viewerJoin.do");
        log.info(viewer.getVId()+" : "+viewer.getVPw());

        viewer = viewerService.join(viewer);

        return viewer;
    }
    */

    @GetMapping("/viewercheck.do")
    public Object viewerCheck(
            @RequestParam String vId) {
        log.info("● ● ● Into viewerCheck.do");
        log.info("● ● ● viewerCheckStage vId : "+vId);

        if(vId.length() < 4) return new Viewer("중복");

        Viewer viewer = new Viewer(vId);
        try{
            viewerService.validateDuplcateViewer(viewer);
            return viewer;
        }catch (IllegalStateException e){
            log.info("IllegalStateException Throws vId : "+vId);
            viewer = new Viewer("중복");
            return viewer;
        }

    }

    @PostMapping("/viewerlogin.do")
    public Object viewerLogin(
            @RequestBody Viewer viewer){
        log.info("● ● ● Into viewerLogin.do");
        log.info(viewer.getVId()+" : "+viewer.getVPw());

        viewer = viewerService.findOneByVId(viewer.getVId()).get();

        return viewer;
    }

    @GetMapping("/viewerdetail.do")
    public Object viewerDetail(
            @RequestBody Viewer viewer){

        String vid = "d";
        viewer = viewerService.findOneByVId(vid).get();

        return viewer;
    }



}
