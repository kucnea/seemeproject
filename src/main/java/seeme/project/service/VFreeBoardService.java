package seeme.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seeme.project.repository.VFreeBoardRepository;

@Service
public class VFreeBoardService {

    private final VFreeBoardRepository vFreeBoardRepository;

    @Autowired
    public VFreeBoardService(VFreeBoardRepository vFreeBoardRepository){
        this.vFreeBoardRepository = vFreeBoardRepository;
    }

}
