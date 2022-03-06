package seeme.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import seeme.project.service.ViewerService;

@Controller
public class ViewerController {

    // 여러 컨트롤러에서 서비스를 가져가 쓸 수 있게 되지만 하나 만들어서 공용으로 쓰는 것이 좋음.
//    private final  viewerService = new ViewerService();
    @Autowired private ViewerService viewerService;

//    @Autowired
//    public ViewerController(ViewerService viewerService){ // 이대로만 쓰면, service를 spring이 알 수 없음.
//        this.viewerService = viewerService;               // ViewerService에 @Service 추가
//    }                                                     // DI

    


}
