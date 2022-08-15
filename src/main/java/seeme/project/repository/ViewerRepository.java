package seeme.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seeme.project.entity.viewer.ViewerEntity;

import java.util.Optional;

@Repository
public interface ViewerRepository extends JpaRepository<ViewerEntity, Long> {

    boolean existsByvIdx(Long vIdx);
    boolean existsByvId(String vId);
    Optional<ViewerEntity> findByvId(String vId);

}
