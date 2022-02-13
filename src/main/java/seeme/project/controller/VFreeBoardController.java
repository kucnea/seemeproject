package seeme.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import seeme.project.service.VFreeBoardService;

@Controller
public class VFreeBoardController {

    private final VFreeBoardService vFreeBoardService;

    @Autowired
    public VFreeBoardController(VFreeBoardService vFreeBoardService){
        this.vFreeBoardService = vFreeBoardService;
    }

}
