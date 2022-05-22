package seeme.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seeme.project.domain.Viewer;

@RestController // Json 형식을 리턴하는 Controller
@Slf4j
@RequestMapping("/viewer")
public class ViewerRestController {

    @PostMapping("/viewerjoin.do")
    public Object viewerJoin(@RequestBody Viewer viewer) {
        log.info("● ● ● Into viewerJoin.do");
        log.info(viewer.getVId()+" : "+viewer.getVPw());

        return viewer;
    }

}
