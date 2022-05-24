package seeme.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록됨
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/viewer/loginpage").permitAll()
                .antMatchers("/viewer/joinpage").permitAll()
                .antMatchers("/viewer/viewerjoin.do").permitAll()
                .antMatchers("/viewer/viewerlogin.do").permitAll()
                .antMatchers("/viewer/**").authenticated()
                .antMatchers("/manager/**").access("hasRole('RoleADMIN') or hasRole('RoleMANAGER')")
                .antMatchers("/admin/**").access("hasRole('RoleADMIN')")
                .anyRequest().permitAll()
                .and()
                    .formLogin()
                    .loginPage("/viewer/loginpage")
                    .loginProcessingUrl("/viewer/viewerlogin.do")
                    .usernameParameter("vid")
                    .passwordParameter("vpw")
                    .defaultSuccessUrl("/viewer/detailpage", true)
                    .permitAll()
                .and()
                    .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/viewer/viewerlogout.do"));

    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
