package seeme.project.config;

import org.springframework.context.annotation.Configuration;

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