package seeme.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // View를 리턴하겠다
@Slf4j
@RequestMapping("/")
public class MainPageController {


    @GetMapping("/")
    public String index(){
        log.info("● ● ● Into INDEX");
        return "index";
    }

    @GetMapping("/hello")
    public String hello(){
        log.info("● ● ● Into hello.");
        return "hello";
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
