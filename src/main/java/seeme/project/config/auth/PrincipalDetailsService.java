package seeme.project.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import seeme.project.entity.viewer.ViewerEntity;
import seeme.project.repository.ViewerRepository;

// 시큐리티 설정에서 loginProcessingUrl("/viewerlogin.do");
// 로그인 요청이 오면 자동으로 UserDetailsService 타입으로 IoC되어있는 loadUserByUsername 함수가 실행
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired private ViewerRepository viewerRepository;

    // 시큐리티 session = Authentication = UserDetails
    // session = Authentication(내부 UserDetails)
    // // session(내부 Authentication(내부 UserDetails))
    @Override
    public UserDetails loadUserByUsername(String vid) throws UsernameNotFoundException {
        System.out.println("vid : "+vid);
        ViewerEntity viewerEntity = viewerRepository.findByVId(vid).get();
        if(viewerEntity !=null) return new PrincipalDetail(viewerEntity);
        else return null;
    }
}
