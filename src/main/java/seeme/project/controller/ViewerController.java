package seeme.project.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seeme.project.entity.viewer.ViewerEntity;
import seeme.project.dto.viewer.ViewerLoginDto;
import seeme.project.service.ViewerService;
import seeme.project.web.SessionConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class ViewerController {

    @Autowired
    ViewerService viewerService;

    @RequestMapping(value = "/getallviewers", method = RequestMethod.GET)
    public List<ViewerLoginDto> getAllViewers(){
        return viewerService.getExistsViewers();
    }

    @RequestMapping(value = "/loginviewer", method = RequestMethod.POST)
    public ViewerLoginDto loginViewer(@RequestBody ViewerEntity viewerEntity, HttpServletRequest request){
        ViewerLoginDto viewerLoginDto = viewerService.loginViewer(viewerEntity);

        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.LOGIN_VIEWER,viewerLoginDto);

        return  viewerLoginDto;
    }

    @RequestMapping(value = "/addviewer", method = RequestMethod.POST)
    public String addViewer(@RequestBody ViewerEntity viewer){ return viewerService.addViewer(viewer); }

    @RequestMapping(value = "/updateviewer", method = RequestMethod.PUT)
    public String updateViewer(@RequestBody ViewerEntity viewer){
        return viewerService.updateViewer(viewer);
    }

    @RequestMapping(value = "/deleteviewer", method = RequestMethod.DELETE)
    public String removeViewer(@RequestBody ViewerEntity viewer){
        return viewerService.removeViewer(viewer);
    }



}
