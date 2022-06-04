package seeme.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import seeme.project.domain.viewer.Viewer;
import seeme.project.service.ViewerService;

@Controller
@Slf4j
@RequestMapping("/viewer/")
public class ViewerController {
    // 컨트롤러가 서비를 통해서 무언가를 할 수 잇음 의존관계 서비스를 의존함
    // 여러 컨트롤러에서 서비스를 가져가 쓸 수 있게 되지만 하나 만들어서 공용으로 쓰는 것이 좋음.
//    private final  viewerService = new ViewerService();

    // 생성자 주입
    private final ViewerService viewerService;

    // 스프링 컨테이너에 등록하면 하나만 넣어 쓸 수 있음, 다른 이점도 있음
    @Autowired
    public ViewerController(ViewerService viewerService){ // 이대로만 쓰면, service를 spring이 알 수 없음.
        this.viewerService = viewerService;               // ViewerService에 @Service 추가
    }                                                     // DI
    //Autowired를 통해 등록된 빈을 가져와 주입 DI

    // 필드주입 ( 나중에 수정할 수 없음 )
//    @Autowired  private ViewerService viewerService;

    // 세터주입 ( 아무나 손 댈 수 있께 열려 있음 )
//    private final ViewerService;
//
//    @Autowired
//    public void setViewerService(ViewerService viewerService){
//        this.viewerService=viewerService;
//    }




    @GetMapping("joinpage")
    public String joinPage(){
        log.info("● ● ● Into JoinPage.");
        return "joinPage";
    }

    @PostMapping("viewerjoin")
    public String viewerjoin(@ModelAttribute("viewer")Viewer viewer){
        log.info("● ● ● Into viewerJoin");
        log.info("● ● ● vid : "+viewer.getVId());

        return "loginPage";
    }


    @GetMapping("loginpage")
    public String loginPage(){
        log.info("● ● ● Into LoginPage.");
        return "loginPage";
    }

    @GetMapping("detailpage")
    public String detailPage(){

        return "detailPage";
    }
    //
}
