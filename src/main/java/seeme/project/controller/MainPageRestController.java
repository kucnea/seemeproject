package seeme.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import seeme.project.domain.Viewer;

@RestController // View를 리턴하겠다
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
