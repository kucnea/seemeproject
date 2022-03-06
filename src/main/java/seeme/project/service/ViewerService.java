package seeme.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seeme.project.domain.Viewer;
import seeme.project.repository.MemoryViewerRepository;
import seeme.project.repository.ViewerRepository;

import javax.swing.text.View;
import java.util.List;
import java.util.Optional;

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

        if(validateDuplcateViewer(viewer)) viewer = viewerRepository.save(viewer);
        else{
            return null;
        }
        return viewer;
    }



    /*
        중복 회원 검증
     */
    private boolean validateDuplcateViewer(Viewer viewer) {

        return (viewer==null);
    }


    /*
        전체 회원 조회
     */
    public List<Viewer> findViewers(){
        return viewerRepository.findAll();
    }





}
