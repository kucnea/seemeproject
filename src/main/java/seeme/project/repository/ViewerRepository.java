package seeme.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seeme.project.domain.Viewer;

import java.util.List;
import java.util.Optional;

@Repository
public interface ViewerRepository extends JpaRepository<Viewer, Long>{

    Viewer save(Viewer viewer);
    Viewer findByVIdx(Long vidx);
    Viewer findByVId(String vId);
//    Optional<Viewer> findByVIdx(Long vIdx);
//    Optional<Viewer> findByVId(String vId);
    List<Viewer> findAll();


}
