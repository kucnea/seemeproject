package seeme.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import seeme.project.domain.Viewer;

@RestController // Json 형식을 리턴하는 Controller
@Slf4j
@RequestMapping("/")
public class MainPageRestController {

    @GetMapping("/getviewer.do")
    public Object getViewer(){
        Viewer viewer = new Viewer("id","pw",1);
        JSONObject jo = new JSONObject(viewer);
        return jo.toString();
    }

}
