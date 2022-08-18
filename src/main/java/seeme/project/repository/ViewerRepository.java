package seeme.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seeme.project.entity.viewer.ViewerEntity;

import java.util.Optional;

@Repository
public interface ViewerRepository extends JpaRepository<ViewerEntity, Long> {

    boolean existsByVIdx(Long vIdx);
    boolean existsByVId(String vId);
    Optional<ViewerEntity> findByVId(String vId);
    Optional<ViewerEntity> findByVIdAndVPw(String vId, String vPw);
}
