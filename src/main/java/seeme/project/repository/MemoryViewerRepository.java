package seeme.project.repository;

import seeme.project.domain.Viewer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class MemoryViewerRepository implements ViewerRepository {
    
    //동시성 위해 ConcurrentHashMap, AtomicLong 사용
    private static Map<AtomicLong, Viewer> vStore = new ConcurrentHashMap<>();
    private static AtomicLong sequence = new AtomicLong(0);

    @Override
    public Viewer save(Viewer viewer) {
        viewer.setVIdx(new AtomicLong(sequence.incrementAndGet()));
        vStore.put(viewer.getVIdx(), viewer);
        return viewer;
    }

    @Override
    public Optional<Viewer> findByVIdx(Long vIdx) {
        return Optional.ofNullable(vStore.get(vIdx));
    }

    @Override
    public Optional<Viewer> findByVId(String vId) {
        return vStore.values().stream()
                .filter((viewer -> viewer.getVId().equals(vId)))
                .findAny();
    }

    @Override
    public List<Viewer> findAll() {
        return new ArrayList<>(vStore.values());
    }

    public void cleaerVStoer(){
        vStore.clear();
    }
}
