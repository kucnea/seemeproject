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
@RequestMapping("/viewer")
public class ViewerRestController {

    @PostMapping("/viewerjoin.do")
    public Object viewerJoin(
            @RequestBody String filterJson,
            HttpServletResponse response,
            ModelMap model ) throws Exception {
        log.debug("● ● ● Into viewerJoin.do");

        JSONObject resMap = new JSONObject();
        Viewer viewer = null;

        try{
            ObjectMapper mapper = new ObjectMapper();
            viewer = (Viewer) mapper.readValue(filterJson, new TypeReference<Viewer>() { });

        }catch (Exception e){
            log.debug("viewerJoin error : "+e.getMessage());
        }

        return viewer;
    }
}
