package seeme.project.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import seeme.project.domain.viewer.Viewer;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryViewerRepositoryTest {

    MemoryViewerRepository repository = new MemoryViewerRepository();

    @AfterEach
    public void afterEach(){
        repository.cleaerVStoer();
    }

    @Test
    public void save(){
        Viewer viewer = new Viewer();
        viewer.setVId("admin");
        viewer.setVPw("admin");
        viewer.setVStatus(3);

        repository.save(viewer);

        Viewer result = repository.findByVId(viewer.getVId()).get();
        Assertions.assertThat(viewer).isEqualTo(result);
    }

    @Test
    public void findByVId(){
        Viewer viewer1 = new Viewer("admin","admin",3);
        repository.save(viewer1);
        Viewer viewer2 = new Viewer("admin2","admin2",3);
        repository.save(viewer2);

        //Optional에서 .get()으로 하나까서 꺼낼 수 있음
        Optional<Viewer> result = repository.findByVId("admin");
        Assertions.assertThat(viewer1).isEqualTo(result.get());

        Viewer result2 = repository.findByVId("admin2").get();
        Assertions.assertThat(viewer2).isEqualTo(result2);
    }


    @Test
    public void findAll(){
        Viewer viewer1 = new Viewer("admin","admin",3);
        repository.save(viewer1);
        Viewer viewer2 = new Viewer("admin2","admin2",3);
        repository.save(viewer2);

        List<Viewer> result = repository.findAll();
        //static import ~ .*; 붙이면 그냥 사용 가능.
        assertThat(result.size()).isEqualTo(2);
    }
}
