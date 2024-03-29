package seeme.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import seeme.project.repository.ViewerRepository;
import seeme.project.service.ViewerService;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private final ViewerService viewerService;
    @Autowired private final ViewerRepository viewerRepository;
    @Autowired private CorsConfig corsConfig;
    @Autowired private  AuthEntryPointJwt unauthorizedHandler;


    @Autowired
    public SecurityConfig(ViewerService viewerService, ViewerRepository viewerRepository) { this.viewerService = viewerService;
        this.viewerRepository = viewerRepository;
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http    .addFilter(corsConfig.corsFilter())
//                .csrf().disable()
//                .authorizeRequests()
//                //antMatchers 해당 경로들은 ,,, permitAll() 접근허용 ,,, authenticated() 인증이 되어야함
//                .antMatchers("/*").permitAll()
//                .antMatchers("/css/**").permitAll()
//                .antMatchers("/img/**").permitAll()
//                .antMatchers("/js/**").permitAll()
//                .antMatchers("/hello").permitAll()
////                .antMatchers("/viewer/joinpage").permitAll()
////                .antMatchers("/viewer/viewerjoin").permitAll()
////                .antMatchers("/viewer/viewerlogin.do").permitAll()
////                .antMatchers("/viewer/viewercheck.do").permitAll()
////                .antMatchers("/viewer/**").authenticated()
////                .antMatchers("/board/list").permitAll()
////                .antMatchers("/manager/**").access("hasRole('RoleADMIN') or hasRole('RoleMANAGER')")
////                .antMatchers("/admin/**").access("hasRole('RoleADMIN')")
//                .anyRequest().authenticated()
//                .and()
//                    .formLogin()
//                    .loginPage("/viewer/loginpage").permitAll()
//                    .usernameParameter("vid")
//                    .passwordParameter("vpw")
//                    .loginProcessingUrl("/viewer/viewerlogin.do")
//                    .defaultSuccessUrl("/viewer/detailpage")
//                    .permitAll()
//                .and()
//                    .logout()
//                    .logoutRequestMatcher(new AntPathRequestMatcher("/viewer/viewerlogout.do"));

        //중복 로그인
//        http.sessionManagement()
//                .maximumSessions(2);
//                중복로그인하면 이전 로그인이 풀림
//                .maxSessionsPreventsLogin(false);

        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/viewer/**").permitAll()
//                .antMatchers("/api/test/**").permitAll()
                .anyRequest().authenticated();


    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(viewerService);
    }

    @Bean // 해당 메서드의 리턴되는 오브젝트를 IoC로 등록
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    }