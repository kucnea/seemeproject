package seeme.project.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = {"/*","/*"})
public class FirstFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("필터 인스턴스 초기화");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("필터, URL : {}",((HttpServletRequest)request).getRequestURI());
        // chain으로 필터에서 컨트톨러로 연결
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info("필터 인스턴스 종료");
        Filter.super.destroy();
    }
}
