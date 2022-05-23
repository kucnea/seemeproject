package seeme.project.repository;

import seeme.project.domain.viewer.Viewer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


public class MemoryViewerRepository implements ViewerRepository {
    
    //동시성 위해 ConcurrentHashMap, AtomicLong 사용
    //DB대신 내부 배열에 저장
    private static Map<Long, Viewer> vStore = new ConcurrentHashMap<>();
    private static Long sequence = 0L;

    @Override
    public Viewer save(Viewer viewer) {
        viewer.setVIdx(viewer.getVIdx()+1);
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
