package seeme.project.controller;


import com.auth0.jwt.JWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import seeme.project.config.JwtUtils;
import seeme.project.config.auth.PrincipalDetails;
import seeme.project.config.payload.response.JwtResponse;
import seeme.project.entity.viewer.ViewerEntity;
import seeme.project.dto.viewer.ViewerLoginDto;
import seeme.project.service.AuthService;
import seeme.project.service.ViewerService;
import seeme.project.web.SessionConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping("/viewer")
public class ViewerController {

    @Autowired ViewerService viewerService;
    @Autowired AuthService authService;

    @RequestMapping(value = "/getallviewers", method = RequestMethod.GET)
    public List<ViewerLoginDto> getAllViewers(){
        return viewerService.getExistsViewers();
    }

//    @RequestMapping(value = "/loginviewer", method = RequestMethod.POST)
//    public ViewerLoginDto loginViewer(@RequestBody ViewerEntity viewerEntity, HttpServletRequest request){
//        ViewerLoginDto viewerLoginDto = viewerService.loginViewer(viewerEntity);
//
//        HttpSession session = request.getSession();
//        session.setAttribute(SessionConstants.LOGIN_VIEWER,viewerLoginDto);
//
//        return  viewerLoginDto;
//    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody ViewerEntity viewerEntity){
        viewerEntity = viewerService.loginViewer(viewerEntity);
        ResponseEntity response = authService.generateAuth(viewerEntity);

        return response;
    }

//    @RequestMapping(value = "/addviewer", method = RequestMethod.POST)
//    public String addViewer(@RequestBody ViewerEntity viewer){ return viewerService.addViewer(viewer); }

    @RequestMapping(value = "/add")
    public String add(@RequestBody ViewerEntity viewerEntity){
        return "";
    }

    @RequestMapping(value = "/updateviewer", method = RequestMethod.PUT)
    public String updateViewer(@RequestBody ViewerEntity viewer){
        return viewerService.updateViewer(viewer);
    }

    @RequestMapping(value = "/deleteviewer", method = RequestMethod.DELETE)
    public String removeViewer(@RequestBody ViewerEntity viewer){
        return viewerService.removeViewer(viewer);
    }



}
