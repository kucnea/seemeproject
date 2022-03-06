package seeme.project.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import seeme.project.domain.Viewer;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryViewerRepositoryTest {

    @Autowired ViewerRepository ViewerRepository;

// 테스트 메소드의 실행 순서는 보장되지 않기때문에, 유의할 것.

    //각 메소드가 끝난 후
    @AfterEach
    public void afterEach(){    }


    @Test
    public void save(){
        Viewer viewer = new Viewer();
        viewer.setVId("admin");
        viewer.setVPw("admin");
        viewer.setVStatus(3);

        Viewer result = ViewerRepository.save(viewer);

//        result = ViewerRepository.findByVIdx(result.getVIdx()).get();
        result = ViewerRepository.findByVIdx(result.getVIdx());
//        Junit 라이브러리
//        Assertions.assertEquals(viewer, result); // 맞으면 콘솔창에 초록불, 틀리면 빨간불
//        Assertions.assertEquals(viewer, null);

//        assertJ 라이브러리
//        Assertions.assertThat(viewer).isEqualTo(result);
//        상위에 import static org.assertj.core.api.Assertions.*; 추가하면 Assertions 생략가능

        assertThat(viewer).isEqualTo(result);

    }

    @Test
    public void findByVIdx(){

        Viewer viewer = new Viewer("admin", "admin", 3);
        ViewerRepository.save(viewer);

        Viewer viewer1 = new Viewer("admin2", "admin2", 3);
        ViewerRepository.save(viewer1);

//        Viewer result = ViewerRepository.findByVId("admin2").get();
        Viewer result = ViewerRepository.findByVId("admin");
        assertThat(result).isEqualTo(viewer1);

    }

    @Test
    public void findAll(){

        Viewer viewer = new Viewer("admin", "admin", 3);
        ViewerRepository.save(viewer);

        Viewer viewer1 = new Viewer("admin2", "admin2", 3);
        ViewerRepository.save(viewer1);

        List<Viewer> result = ViewerRepository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}
