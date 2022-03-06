package seeme.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import seeme.project.domain.VFreeBoard;

import java.util.Optional;

@Repository
public interface VFreeBoardRepository extends JpaRepository<VFreeBoard, Long> {

    VFreeBoard save(VFreeBoard vFreeBoard);
    Page<VFreeBoard> findAll(Pageable pageable);

//    @Query(value = "SELECT v FROM vFreeBoard v WHERE v.vFTitle LIKE %:searchTarget% OR v.FContent LIKE %:searchTarget% OR v.viewer.vid LIKE %:searchTarget%")
//    Page<VFreeBoard> findAllSearch(String searchTarget, Pageable pageable);
}
