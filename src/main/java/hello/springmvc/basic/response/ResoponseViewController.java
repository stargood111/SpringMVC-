package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResoponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data","hello!");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model){

        model.addAttribute("data","hello!");

        return "response/hello";
    }
    @RequestMapping("/response/hello") // 권장하지 않음(명시적이지 않다)
    public void responseViewV3(Model model){

        model.addAttribute("data","hello!");
    }
}
