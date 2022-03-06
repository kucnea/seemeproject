package seeme.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import seeme.project.domain.VFreeBoard;
import seeme.project.repository.VFreeBoardRepository;

import org.springframework.data.domain.Pageable;

@Service
public class VFreeBoardService {

    @Autowired private VFreeBoardRepository vFreeBoardRepository;

    public Page<VFreeBoard> searchList(int page, int size, Pageable pageable){
        return vFreeBoardRepository.findAll(pageable);
    }

    public Page<VFreeBoard> searchListByObject(int page, int size, String searchTarget, Pageable pageable){

        return vFreeBoardRepository.findAll(pageable);
    }
}
