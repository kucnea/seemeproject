package seeme.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seeme.project.domain.viewer.Viewer;

public interface SpringDataJpaRepository extends JpaRepository<Viewer, Long> {
}
