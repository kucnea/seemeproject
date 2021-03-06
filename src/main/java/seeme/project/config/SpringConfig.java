package seeme.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import seeme.project.aop.TimeTraceAop;
import seeme.project.interceptor.LoggerInterceptor;
import seeme.project.repository.JpaViewerRepository;
import seeme.project.repository.MemoryViewerRepository;
import seeme.project.repository.ViewerRepository;
import seeme.project.service.ViewerService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {


    //aop 이걸 알려줬는데 무한루프.
//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }


//    private final ViewerRepository viewerRepository;
//
//    public SpringConfig(ViewerRepository viewerRepository){
//        this.viewerRepository = viewerRepository;
//    }

//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

    //JpaRepository extend 한 interface가 있다면 필요 없음
//    @PersistenceContext
//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }


//    @Bean
//    public ViewerService viewerService(){ return new ViewerService((viewerRepository()));}
//
//    @Bean
//    public ViewerRepository viewerRepository(){
//        return new JpaViewerRepository(em);
//    }



}