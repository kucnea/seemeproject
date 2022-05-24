package seeme.project.handler.springsecurityHandler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        List<String> roleNames = new ArrayList<>();

        //Authentication 객체는 인증된 대상의 정보를 담고있다.
        //그 객체에서 authority(권한)을 추출해 roleNames 리스트에 담는다.
        authentication.getAuthorities().forEach(authority -> {
            roleNames.add(authority.getAuthority());
        });

        //ROLE_ADMIN이 포함되어 있으면 /admin/adminpage로 리다이렉트
        if(roleNames.contains("ROLE_ADMIN")){
            response.sendRedirect("/admin/adminpage");
            return;
        }

        if(roleNames.contains("ROLE_MEMBER")){
            response.sendRedirect("/board/list");
            return;
        }

        response.sendRedirect("/viewer/login");

    }


}
