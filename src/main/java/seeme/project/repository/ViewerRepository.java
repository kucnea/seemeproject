package seeme.project.repository;

import seeme.project.domain.viewer.Viewer;

import java.util.List;
import java.util.Optional;

public interface ViewerRepository {

    Viewer save(Viewer viewer);
    Optional<Viewer> findByVIdx(Long vIdx);
    Optional<Viewer> findByVId(String vId);
    List<Viewer> findAll();

}
