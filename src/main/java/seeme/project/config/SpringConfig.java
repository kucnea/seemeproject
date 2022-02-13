package seeme.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import seeme.project.repository.MemoryVFreeBoardRepository;
import seeme.project.repository.VFreeBoardRepository;
import seeme.project.service.VFreeBoardService;

@Configuration
public class SpringConfig {

    //VFreeBoard Service, Repository 빈 등록을 자바 코드로. 평소에는 어노테이션으로 해둘것임.
//    @Bean
//    public VFreeBoardService vFreeBoardService() {
//        return new VFreeBoardService(vFreeBoardRepository());
//    }
//
//    @Bean
//    public VFreeBoardRepository vFreeBoardRepository(){
//        return new MemoryVFreeBoardRepository();
//    }


}