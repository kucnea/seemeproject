package seeme.project.service;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import seeme.project.domain.Viewer;
import seeme.project.repository.MemoryViewerRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ViewerServiceTest {

    ViewerService viewerService = new ViewerService();
    MemoryViewerRepository repository = new MemoryViewerRepository();

    @Test
    void join() {
        //given
        Viewer viewer = new Viewer("admin","admin",3);

        //when
        System.out.println(viewerService.join(viewer)==null);
        viewer = viewerService.join(viewer);

        //then
        System.out.println(viewer.toString());
    }

    @Test
    void joinWithError(){
        //given

        //when

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