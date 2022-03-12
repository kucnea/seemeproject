package seeme.project.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import seeme.project.domain.Viewer;
import seeme.project.repository.MemoryViewerRepository;
import seeme.project.repository.ViewerRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class ViewerServiceIntegrationTest {

    // Test 는 제일 끝 단이라 가장 편한거 사용하면 됨. 얘를 갖다가 다른데게 써보지 않음.
    @Autowired ViewerService viewerService;
    @Autowired ViewerRepository viewerRepository;

    @Test
//    @Commit ( 테스트지만 DB에 반영됨 )
    void join() {
        //given
        Viewer viewer = new Viewer("admin","admin",3);

        //when
        Viewer result = viewerService.join(viewer);
        Viewer result2 = viewerService.findOneByVIdx(result.getVIdx()).get();

        //then
        assertThat(viewer.getVIdx()).isEqualTo(result.getVIdx());
        assertThat(result.getVIdx()).isEqualTo(result2.getVIdx());
    }

    @Test
    void exceptionJoin(){
        //given
        Viewer viewer1 = new Viewer("admin","admin",3);
        Viewer viewer2 = new Viewer("admin","admin",3);

        //when
        viewerService.join(viewer1);
        assertThrows(IllegalStateException.class, () -> viewerService.join(viewer2));

        //then
    }

    @Test
    void findViewers() {
        //given
        Viewer viewer = new Viewer("admin","admin",3);

        //when
        viewer = viewerService.join(viewer);
        Viewer result = viewerService.findOneByVId("admin").get();

        //then
        assertThat(result).isEqualTo(viewer);
    }

    @Test
    void findOneByVIdx() {
        //given
        Viewer viewer = new Viewer("admin", "admin",3);

        //when
        viewer = viewerService.join(viewer);
        long target = viewer.getVIdx();
        Viewer result = viewerService.findOneByVIdx(target).get();

        //then
        assertThat(viewer).isEqualTo(result);
    }

    @Test
    void findOneByVId() {
        //given
        Viewer viewer = new Viewer("admin", "admin",3);

        //when
        viewer = viewerService.join(viewer);
        String target = viewer.getVId();
        Viewer result = viewerService.findOneByVId(target).get();

        //then
        assertThat(viewer).isEqualTo(result);
    }
}