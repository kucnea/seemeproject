package seeme.project.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seeme.project.domain.Viewer;

import javax.servlet.http.HttpServletResponse;

@RestController // Json 형식을 리턴하는 Controller
@Slf4j
public class ViewerRestController {

    @PostMapping("/viewer/viewerjoin.do")
    public Object viewerJoin(
            @RequestBody Viewer viewer,
            HttpServletResponse response,
            ModelMap model ) throws Exception {
        log.debug("● ● ● Into viewerJoin.do");

        return viewer;
    }
}
