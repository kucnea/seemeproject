package seeme.project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import seeme.project.config.JwtUtils;
import seeme.project.config.auth.PrincipalDetails;
import seeme.project.config.payload.response.JwtResponse;
import seeme.project.entity.viewer.ViewerEntity;
import seeme.project.repository.ViewerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuthService {

    @Autowired ViewerRepository viewerRepository;
    @Autowired AuthenticationManager authenticationManager;
    @Autowired JwtUtils jwtUtils;

    public ResponseEntity<?> generateAuth(ViewerEntity viewerEntity){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(viewerEntity.getVId(), viewerEntity.getVPw())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateToken(authentication);

        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        List<String> roles = principalDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                principalDetails.getUsername(),
                principalDetails.getUserNick(),
                roles));
    }

}
