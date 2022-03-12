package seeme.project.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seeme.project.domain.Viewer;
import seeme.project.repository.MemoryViewerRepository;
import seeme.project.repository.ViewerRepository;

import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.*;


class ViewerServiceTest {
//    // ctrl + shift + t 누르면 테스트 바로 만들 수 있음.
//
//    ViewerService viewerService = new ViewerService();
//
//    // ViewerService에서 new로 viewerReposiroy를 생성해 다른 객체지만,
//    // static으로 class에 붙여 사용해서 사용 가능
//    MemoryViewerRepository viewerRepository = new MemoryViewerRepository();


    ViewerService viewerService;
    MemoryViewerRepository viewerRepository;

    @BeforeEach
    public void beforeEach(){
        viewerRepository = new MemoryViewerRepository();
        viewerService = new ViewerService(viewerRepository); // DI
    }
//    viewerService 입장에서는 repository를 직접 넣지않고 받아옴. DI

    @AfterEach
    void aftereEach(){
        viewerRepository.cleaerVStoer();
    }

    @Test
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

        //위의 방식으로만 예외가 검출되는지 확인해도 되지만,
//        IllegalStateException e = assertThrows(IllegalStateException.class, () -> viewerService.join(viewer2));
//        이렇게 받아서도 메세지를 까볼 수도 있음.

        // 번거롭지만 try catch사용한 구식 방법
//        try {
//            viewerService.join(viewer2);
//            fail();
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        //then
    }

    @Test
    void findViewers() {
        //given

        //when

        //then
    }

    @Test
    void findOneByVIdx() {
        //given

        //when

        //then
    }

    @Test
    void findOneByVId() {
        //given

        //when

        //then
    }
}