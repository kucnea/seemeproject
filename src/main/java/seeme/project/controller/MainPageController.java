package seeme.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainPageController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello");
        return "hello";
    }

    @GetMapping("next-page")
    public String nextPage(@RequestParam("name") String name, Model model){

        model.addAttribute("name", name);
        return "next-page";

    }

    @GetMapping("api-style-page")
    @ResponseBody
    public String apiStylePage(@RequestParam("name") String name){
        return "hello"+name; // 페이지에 그냥 데이터가 그대로 전송됨
    }

    @GetMapping("hello-api")
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
