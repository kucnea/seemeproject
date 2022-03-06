package seeme.project.service;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import seeme.project.domain.Viewer;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ViewerServiceTest {

//    ViewerService viewerService = new ViewerService();
//    MemoryViewerRepository viewerRepository = new MemoryViewerRepository();
    @Autowired ViewerService viewerService;
//    MemoryViewerRepository viewerRepository;

    // DI 과정
//    @BeforeEach
//    void beforeEach(){
//        viewerRepository = new MemoryViewerRepository();
//        viewerService = new ViewerService(viewerRepository);
//    }

//    @AfterEach
//    void afterEach(){
//        viewerRepository.clearVList();
//    }

    @Test
    void join() {
        //given
        Viewer viewer = new Viewer("admin","admin",3);

        //when
        long saveIdx = viewerService.join(viewer);

        //then
//        Viewer findViewer = viewerService.findOne(saveIdx).get();
        Viewer findViewer = viewerService.findOne(saveIdx);
        assertThat(viewer.getVIdx()).isEqualTo(findViewer.getVIdx());

    }

    @Test
    void joinWithError(){
        //given
        Viewer viewer = new Viewer("admin", "admin",3);
        Viewer viewer2 = new Viewer("admin", "admin",3);

        //when
        viewerService.join(viewer);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> viewerService.join(viewer2));

//        try {
//            viewerService.join(viewer2);
//            fail();
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 아이디 입니다.");
//        }

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 아이디 입니다.");


        //then


    }

    @Test
    void findViewers() {
        //given

        //when

        //then

    }

    @Test
    void findOne() {
        //given

        //when

        //then

    }
}