package seeme.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seeme.project.domain.Viewer;
import seeme.project.repository.MemoryViewerRepository;
import seeme.project.repository.ViewerRepository;

import javax.swing.text.View;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ViewerService {

    // 이 경우 테스트에서 쓰는 Repository와 다른 객체가 만들어져서 두 개가 사용됨.
    // vList가 static이기 때문에 같은 DB를 사용할 수 있지만, 좋지않음.
    private final MemoryViewerRepository viewerRepository = new MemoryViewerRepository();
//    @Autowired private ViewerRepository viewerRepository;


    /*
        회원가입
     */
    public Viewer join(Viewer viewer){

        // 중복 회원 검증 ( IllegalStateException 발생 )
        validateDuplcateViewer(viewer);

        viewer = viewerRepository.save(viewer);

        return viewer;
    }


    /*
        중복 회원 검증
    */
    private void validateDuplcateViewer(Viewer viewer) {
        viewerRepository.findByVId(viewer.getVId())
                .ifPresent(v -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }


    /*
        전체 회원 조회
     */
    public List<Viewer> findViewers(){

        return viewerRepository.findAll();
    }

    /*
        idx로 회원 한명 조회
    */
    public Optional<Viewer> findOneByVIdx(AtomicLong vIdx){
        return viewerRepository.findByVIdx(vIdx);
    }

    /*
        id로 회원 한명 조회
    */
    public Optional<Viewer> findOneByVId(String vId){
        return viewerRepository.findByVId(vId);
    }



}
