package seeme.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import seeme.project.domain.Viewer;

@Controller // View를 리턴하겠다
//@RestController // json 형식을 이용하기위한 컨트롤러 어노테이션
@Slf4j
@RequestMapping("/")
public class MainPageController {


    @GetMapping("/")
    public Object index(){
        Viewer viewer = new Viewer("id","pw",1);

        return viewer;
    }

    @GetMapping("/hello")
    public String hello(Model model){
        Viewer viewer = new Viewer("id","pw",1);
        JSONObject jo = new JSONObject(viewer);
        model.addAttribute(jo);
        return "hello";
    }



    @GetMapping("/getviewer.do")
    public @ResponseBody Object getViewer(){
        Viewer viewer = new Viewer("id","pw",1);
        JSONObject jo = new JSONObject(viewer);
        return jo.toString();
    }
//    @GetMapping({"","/"})
//    public String index(Model model){
//        model.addAttribute("data","hello");
//        log.info("INDEX Page OnLoad");
//        return "hello";
//    }
//
//    @GetMapping("next-page")
//    public String nextPage(@RequestParam("name") String name, Model model) {
//
//        model.addAttribute("name", name);
//        return "next-page";
//
//    }
//
//
//    //JSON Test
//    @GetMapping("helloapi")
//    @ResponseBody
//    public Hello helloApi(@RequestParam("name") @Nullable String name){
//            Hello hello = new Hello();
//            hello.setName(name);
//
//        return hello; // JSON 방식으로 페이지에 데이터가 전송됨
//    }
//
//
//
//    static class Hello{
//        private String name;
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }
}
