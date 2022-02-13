package seeme.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seeme.project.domain.Viewer;
import seeme.project.repository.MemoryViewerRepository;
import seeme.project.repository.ViewerRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ViewerService {

    // 이 경우 테스트에서 쓰는 Repository와 다른 객체가 만들어져서 두 개가 사용됨.
    // vList가 static이기 때문에 같은 DB를 사용할 수 있지만, 좋지않음.
//    private final ViewerRepository viewerRepository = new MemoryViewerRepository();
    private final ViewerRepository viewerRepository;

    @Autowired
    public ViewerService(ViewerRepository viewerRepository){

        this.viewerRepository = viewerRepository;
    }

    /*
        회원가입
     */
    public long join(Viewer viewer){
        // 같은 id 회원 제외
//        Optional<Viewer> result = viewerRepository.findByVId(viewer.getvId());
//        result.ifPresent(viewer1 -> {
//            throw new IllegalStateException("이미 존재하는 아이디입니다.");
//        });
//        result.orElseGet() : 있으면 꺼내기.

        // 같은 id 회원 제외
        // 선택구간 메소드로 뽑아내기 : refactor -> Extract Method
        validateDuplcateViewer(viewer);
        viewerRepository.save(viewer);
        
        return viewer.getvIdx();
    }



    /*
        중복 회원 검증
     */
    private void validateDuplcateViewer(Viewer viewer) {
        viewerRepository.findByVId(viewer.getvId())
                .ifPresent(viewer1 -> {
            throw new IllegalStateException("이미 존재하는 아이디 입니다.");
        });
    }


    /*
        전체 회원 조회
     */
    public List<Viewer> findViewers(){
        return viewerRepository.findAll();
    }

    public Optional<Viewer> findOne(Long vIdx){
        return viewerRepository.findByVIdx(vIdx);
    }




}
