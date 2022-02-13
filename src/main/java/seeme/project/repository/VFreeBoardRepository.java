package seeme.project.repository;

import seeme.project.domain.VFreeBoard;
import seeme.project.domain.Viewer;

import java.util.List;
import java.util.Optional;

public interface VFreeBoardRepository {

    VFreeBoard save(VFreeBoard vFreeBoard);
    Optional<VFreeBoard> findByVFIdx(Long vFIdx);
    Optional<VFreeBoard> findByVFTitle(String vFTitle);
    Optional<VFreeBoard> findByVFContent(String vFContent);
    List<VFreeBoard> findAll();

}
