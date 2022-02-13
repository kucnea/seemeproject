package seeme.project.repository;

import org.springframework.stereotype.Repository;
import seeme.project.domain.VFreeBoard;
import seeme.project.domain.Viewer;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemoryVFreeBoardRepository implements VFreeBoardRepository{

    private static Map<Long, VFreeBoard> vFList = new ConcurrentHashMap<>();
    private static AtomicLong sequence = new AtomicLong();


    @Override
    public VFreeBoard save(VFreeBoard vFreeBoard) {
        return null;
    }

    @Override
    public Optional<VFreeBoard> findByVFIdx(Long vFIdx) {
        return Optional.empty();
    }

    @Override
    public Optional<VFreeBoard> findByVFTitle(String vFTitle) {
        return Optional.empty();
    }

    @Override
    public Optional<VFreeBoard> findByVFContent(String vFContent) {
        return Optional.empty();
    }

    @Override
    public List<VFreeBoard> findAll() {
        return null;
    }
}
