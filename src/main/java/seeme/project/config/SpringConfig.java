package seeme.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import seeme.project.repository.JpaViewerRepository;
import seeme.project.repository.MemoryViewerRepository;
import seeme.project.repository.ViewerRepository;
import seeme.project.service.ViewerService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }
    @PersistenceContext
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }

//    @Bean
//    public ViewerService viewerService(){ return new ViewerService((viewerRepository()));}
//
//    @Bean
//    public ViewerRepository viewerRepository(){
//        return new JpaViewerRepository(em);
//    }



}