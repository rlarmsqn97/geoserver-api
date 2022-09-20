package jbt.boo.some;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String Home() {
        return "kakao";
    }

    @GetMapping("/{page}")
    public ModelAndView view(
            @PathVariable(value="page") String page
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(page);
        return modelAndView;
    }
}
