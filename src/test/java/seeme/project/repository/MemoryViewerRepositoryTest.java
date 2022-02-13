package seeme.project.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import seeme.project.domain.Viewer;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryViewerRepositoryTest {

    MemoryViewerRepository repository = new MemoryViewerRepository();


// 테스트 메소드의 실행 순서는 보장되지 않기때문에, 유의할 것.

    //각 메소드가 끝난 후
    @AfterEach
    public void afterEach(){
        repository.clearVList();
    }


    @Test
    public void save(){
        Viewer viewer = new Viewer();
        viewer.setvId("admin");
        viewer.setvPw("admin");
        viewer.setvStatus(3);

        Viewer result = repository.save(viewer);

        result = repository.findByVIdx(result.getvIdx()).get();

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
        repository.save(viewer);

        Viewer viewer1 = new Viewer("admin2", "admin2", 3);
        repository.save(viewer1);

        Viewer result = repository.findByVId("admin2").get();
        assertThat(result).isEqualTo(viewer1);

    }

    @Test
    public void findAll(){

        Viewer viewer = new Viewer("admin", "admin", 3);
        repository.save(viewer);

        Viewer viewer1 = new Viewer("admin2", "admin2", 3);
        repository.save(viewer1);

        List<Viewer> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}
