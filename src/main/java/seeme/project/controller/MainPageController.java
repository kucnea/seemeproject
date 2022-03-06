package seeme.project.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class MainPageController {
    @GetMapping("/")
    public String rootPage(Model model){
        model.addAttribute("data","hello");
        log.info("Loot Page OnLoad");
        return "hello";
    }
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello");
        log.info("Main Page OnLoad");
        return "hello";
    }

    @GetMapping("next-page")
    public String nextPage(@RequestParam("name") String name, Model model){

        model.addAttribute("name", name);
        return "next-page";

    }


    //JSON Test
    @GetMapping("helloapi")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
            Hello hello = new Hello();
            hello.setName(name);

        return hello; // JSON 방식으로 페이지에 데이터가 전송됨
    }



    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
