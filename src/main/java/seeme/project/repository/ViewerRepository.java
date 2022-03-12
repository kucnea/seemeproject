package seeme.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seeme.project.domain.Viewer;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public interface ViewerRepository {

    Viewer save(Viewer viewer);
    Optional<Viewer> findByVIdx(Long vIdx);
    Optional<Viewer> findByVId(String vId);
    List<Viewer> findAll();

}
