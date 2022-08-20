package seeme.project.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import seeme.project.config.auth.PrincipalDetails;
import seeme.project.dto.viewer.ViewerLoginDto;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;


    // Authentication 객체 만들어 리턴 => 의존 : AuthenticationManager
    // 인증 요청시 실행되는 함수 => /loginviewer
    @Override
    public Authentication attemptAuthentication (HttpServletRequest request, HttpServletResponse response)
        throws AuthenticationException {

        log.info("JwtAuthenticationFilter Stage");

        //request 의 vId, vPw 파싱해서 Object 로 받기
        ObjectMapper om = new ObjectMapper();
        ViewerLoginDto viewerLoginDto = null;
        try{
            viewerLoginDto = om.readValue(request.getInputStream(), ViewerLoginDto.class);
        } catch (Exception e){
            log.info(e.getMessage());
        }

        log.info("JwtAuthenticationFilter viewerLoginDto.getVId() : "+viewerLoginDto.getVId());

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                viewerLoginDto.getVId(), viewerLoginDto.getVPw()
        );

        log.info("JwtAuthenticationFilter Token create complete");

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        log.info("Authentication principalDetails.getUsername : "+principalDetails.getUsername());
        log.info("JwtAuthenticationFilter End Stage");

        return authentication;
    }

    // jwt 토큰 생성해서 response 에 담아주기
    @Override
    protected void successfulAuthentication (HttpServletRequest request, HttpServletResponse response,
                                             FilterChain chain, Authentication authResult) throws IOException, ServletException {

        log.info("successfulAuthentication Stage.");

        PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();

        log.info("principal vId : "+principalDetails.getUsername());
        log.info("principal vPw : "+principalDetails.getPassword());

        String jwtToken = JWT.create().withSubject(principalDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .withClaim("vId",principalDetails.getUsername())
                .withClaim("vPw",principalDetails.getPassword())
                .sign(Algorithm.HMAC512(JwtProperties.SECRET));

        log.info("successfulAuthentication End Stage");

        response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + jwtToken);
    }


}
