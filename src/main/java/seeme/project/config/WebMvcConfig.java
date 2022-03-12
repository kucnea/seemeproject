package seeme.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import seeme.project.interceptor.LoggerInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoggerInterceptor())
                .addPathPatterns("/*");
//                .excludePathPatterns("/noneInterceptor"); // 해당경로는 인터셉터가 가로채지 않음.
    }
}
