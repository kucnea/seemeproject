package seeme.project.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import seeme.project.entity.viewer.ViewerEntity;
import seeme.project.model.viewer.Viewer;
import seeme.project.service.ViewerService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class ViewerController {

    @Autowired
    ViewerService viewerService;

    @RequestMapping(value = "/getallviewers", method = RequestMethod.GET)
    public List<Viewer> getAllViewers(){
        return viewerService.getExistsViewers();
    }

    @RequestMapping(value = "/addviewer", method = RequestMethod.POST)
    public String addViewer(@RequestBody ViewerEntity viewer){

        return viewerService.addViewer(viewer);
    }

    @RequestMapping(value = "/updateviewer", method = RequestMethod.PUT)
    public String updateViewer(@RequestBody ViewerEntity viewer){
        return viewerService.updateViewer(viewer);
    }

    @RequestMapping(value = "/deleteviewer", method = RequestMethod.DELETE)
    public String removeViewer(@RequestBody ViewerEntity viewer){
        return viewerService.removeViewer(viewer);
    }



}
