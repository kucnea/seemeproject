package seeme.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import seeme.project.service.VFreeBoardService;
import seeme.project.domain.VFreeBoard;


@Controller
@Slf4j
@RequestMapping("/vboard")
public class VFreeBoardController {

    @Autowired private VFreeBoardService vFreeBoardService;

    @GetMapping("/list")
    @ResponseBody
    public Page<VFreeBoard> getList(Model model
            , @RequestParam("page") @Nullable Integer page
            , @RequestParam("size") @Nullable Integer size
            , @RequestParam("searchTarget") @Nullable String searchTarget
            , Pageable pageable){

        log.info("vFreeBoard List Stage");
        if(page==null) page=1;
        if(size==null) size=6;
        page--;

        Page<VFreeBoard> pages = null;
        if(searchTarget!=null) pages = vFreeBoardService.searchListByObject(page,size,searchTarget, pageable);
        else pages = vFreeBoardService.searchList(page, size, pageable);

        if(page<0) page = 0;
        else if(page > pages.getTotalPages()) page=pages.getTotalPages();

        return pages;
    }


}
