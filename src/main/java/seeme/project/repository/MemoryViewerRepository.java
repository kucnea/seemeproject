package seeme.project.repository;

import org.springframework.stereotype.Repository;
import seeme.project.domain.Viewer;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemoryViewerRepository implements ViewerRepository {

    // 동시성 이슈로 ConcurrentHashMap을 HashMap 대신 사용.
    private static Map<Long,Viewer> vList = new ConcurrentHashMap<>();
    // 동시성 이슈로 AtomicLong 사용.
    private static AtomicLong sequence = new AtomicLong();

    @Override
    public Viewer save(Viewer viewer) {
        viewer.setVIdx(sequence.incrementAndGet());
        vList.put(viewer.getVIdx(), viewer);
        return viewer;
    }

    @Override
    public Optional<Viewer> findByVIdx(Long vIdx) {

        return Optional.ofNullable(vList.get(vIdx));
    }

    @Override
    public Optional<Viewer> findByVId(String vId) {

        return vList.values().stream()
                .filter(viewer -> viewer.getVId().equals(vId))
                .findAny();
    }

    @Override
    public List<Viewer> findAll() {

        return new ArrayList<>(vList.values());
    }

    public void clearVList(){
        vList.clear();
    }
}
