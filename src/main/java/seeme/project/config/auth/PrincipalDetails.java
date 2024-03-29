package seeme.project.config.auth;

// 시큐리티가 로그인 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
// 로그인 완료가되면 시큐리티 session 을 만들어준다. ( Security ContextHolder )
// 오브젝트 -> Authentication 타입 객체
// Authentication 안에 유저정보가 있어야함.
// 유저 오브젝트 타입 -> 유저디테일 타입 객체

// Security Session -> Authentication -> userDetails(PrincipalDetail)

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import seeme.project.entity.viewer.ViewerEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

public class PrincipalDetails implements UserDetails {

    private ViewerEntity viewerEntity; //콤포지션

    public PrincipalDetails(ViewerEntity viewerEntity){ this.viewerEntity = viewerEntity; }

    // 해당 유저의 권한을 리턴하는 곳.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return viewerEntity.getVStatus();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return viewerEntity.getVPw();
    }

    @Override
    public String getUsername() {
        return viewerEntity.getVId();
    }

    public String getUserNick() { return viewerEntity.getVNick(); }

    // 계정이 만료되지 않았는지 리턴. ( true 리턴시 만료되지 않음을 의미 )
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겨있지 않았는지 리턴. ( true 리턴시 계정이 잠겨있지 않음을 의미 )
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 계정의 패스워드가 만료되지 않았는지를 리턴 ( true 리턴시 만료되지 않음을 의미 )
    // 너무 오래사용한지 등
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정이 사용가능한 계정인지를 리턴 ( true 리턴시 사용 가능한 계정인지를 의미 )
    // 너무 오래 사용되지 않음 계정이라면 등..
    @Override
    public boolean isEnabled() {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(viewerEntity.getVLoginDate());
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new Date());

        // 미구현
        // 테스트 좀 해보고.
        // 현재시간 - 로그인시간 > 1년 이면 return false;
        return true;
    }
}
