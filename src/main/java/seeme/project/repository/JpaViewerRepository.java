package seeme.project.repository;

import org.springframework.stereotype.Repository;
import seeme.project.domain.Viewer;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaViewerRepository implements ViewerRepository{

    private final EntityManager em;

    public JpaViewerRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Viewer save(Viewer viewer) {
        em.persist(viewer);
        return viewer;
    }

    @Override
    public Optional<Viewer> findByVIdx(Long vIdx) {
        Viewer viewer = em.find(Viewer.class, vIdx);
        return Optional.ofNullable(viewer);
    }

    @Override
    public Optional<Viewer> findByVId(String vId) {
        return em.createQuery("select v from Viewer v where v.vId = :vId",Viewer.class)
                .setParameter("vId",vId)
                .getResultList()
                .stream()
                .findAny();
    }

    @Override
    public List<Viewer> findAll() {
        return em.createQuery("select v from Viewer v", Viewer.class).getResultList();
    }




}
