package seeme.project.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import seeme.project.config.auth.PrincipalDetails;
import seeme.project.entity.viewer.ViewerEntity;
import seeme.project.repository.ViewerRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private ViewerRepository viewerRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, ViewerRepository viewerRepository){
        super(authenticationManager);
        this.viewerRepository = viewerRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        log.info("JwtAuthorizationFilter doFilterInternal Stage");

        String header = request.getHeader(JwtProperties.HEADER_STRING);
        if(header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)){
            chain.doFilter(request, response);
            return ;
        }

        log.info("header : "+header);

        String token = request.getHeader(JwtProperties.HEADER_STRING)
                .replace(JwtProperties.TOKEN_PREFIX, "");

        log.info("token : "+token);

        String vId = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET)).build().verify(token)
                .getClaim("vId").asString();

        log.info("vId : "+vId);

        if(vId != null){
            ViewerEntity viewerEntity= viewerRepository.findByVId(vId).get();

            // 스프링 시큐리티의 권한 처리
            // 토큰을 만들어 Authentication 객체를 만들어 저장
            PrincipalDetails principalDetails = new PrincipalDetails(viewerEntity);
            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(
                            principalDetails,                   // 컨트롤러에서 DI 해서 쓸 때 사용하기 편함
                            null,                               // 패스워드는 널처리, 지금 인증하는건 아님.
                            principalDetails.getAuthorities()
                    );

            // 강제로 시큐리티의 세션에 접근하여 값 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        log.info("JwtAuthorizationFilter doFilterInternal Stage");

        chain.doFilter(request, response);
    }

}
