package seeme.project.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seeme.project.dto.viewer.ViewerLoginDto;
import seeme.project.entity.viewer.ViewerEntity;
import seeme.project.repository.ViewerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ViewerService {

    private final ViewerRepository viewerRepository;

    @Autowired
    public ViewerService(ViewerRepository viewerRepository){
        this.viewerRepository = viewerRepository;
    }

    // 모든 회원 조회
    public List<ViewerLoginDto> getExistsViewers(){

        try{

            List<ViewerEntity> viewers = viewerRepository.findAll();
            List<ViewerLoginDto> customViwers = new ArrayList<>();

            viewers.stream().forEach(e -> {
                ViewerLoginDto viewer = new ViewerLoginDto();
                BeanUtils.copyProperties(e, viewer);
                customViwers.add(viewer);
            });

            return customViwers;
        }catch (Exception e){
            throw e;
        }

    }

    // 로그인
    public ViewerLoginDto loginViewer(ViewerEntity viewer){

        try{
            log.info("loginViewer Stage");
            log.info(viewer.getVId());
            ViewerEntity viewerEntity = viewerRepository.findByVIdAndVPw(viewer.getVId(),viewer.getVPw()).get();
            log.info("viewerEntity : "+viewerEntity.getVId());
            ViewerLoginDto customViewer = ViewerLoginDto.from(viewerEntity);
            return customViewer;
        }catch (Exception e){
            log.info("throw Exception : "+e.getMessage());
            ViewerLoginDto customViewer = new ViewerLoginDto();
            return customViewer;
        }

    }

    // 회원 주가
    public String addViewer(ViewerEntity viewer){

        try{

            if(!viewerRepository.existsByVId(viewer.getVId())){
                viewerRepository.save(viewer);
                return "회원 가입에 성공했습니다.";
            }else{
                return "이미 존재하는 회원 아이디 입니다.";
            }

        }catch (Exception e){
            throw e;
        }

    }

    // 회원 삭제
    public String removeViewer(ViewerEntity viewer){

        try{

            if(viewerRepository.existsByVIdx(viewer.getVIdx())){
                viewerRepository.delete(viewer);
                return "회원 탈퇴에 성공했습니다.";
            }else{
                return "존재하지 않는 회원입니다.";
            }

        }catch (Exception e){
            throw e;
        }

    }

    // 회원 수정
    public String updateViewer(ViewerEntity viewer){

        try{

            if(viewerRepository.existsByVIdx(viewer.getVIdx())){
                viewerRepository.save(viewer);
                return "회원 정보 수정에 성공했습니다.";
            }else{
                return "존재하지 않는 회원입니다.";
            }

        }catch (Exception e){
            throw e;
        }

    }

}
