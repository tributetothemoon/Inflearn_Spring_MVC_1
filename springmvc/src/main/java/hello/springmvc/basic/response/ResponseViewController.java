package hello.springmvc.basic.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseView1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");

        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseView2(Model model) {
        model.addAttribute("data", "hello!");

        return "response/hello";    // 뷰의 논리적 이름이 된다.
    }

    @RequestMapping("/response/hello")  // 요청 url이 곧 뷰의 경로가 된다.
    public void responseView3(Model model) {
        model.addAttribute("data", "hello!");
    }

}
