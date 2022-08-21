package seeme.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import seeme.project.config.JwtAuthenticationFilter;
import seeme.project.config.auth.PrincipalDetails;
import seeme.project.entity.viewer.ViewerEntity;
import seeme.project.repository.ViewerRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/viewer/auth")
@Slf4j
public class AuthController {

    @Autowired AuthenticationManager authenticationManager;

    @Autowired ViewerRepository viewerRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> authenticateViewer(@RequestBody ViewerEntity viewerEntity){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(viewerEntity.getVId(), viewerEntity.getVPw())
        );

//        SecurityContextHolder.getContext().setAuthentication(authentication);
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        log.info("principalDetails userName : "+principalDetails.getUsername());

        String jwt =

        ResponseEntity.ok()

        return null;
    }



}
