package htw.berlin.webtech.Webtech.model.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWordController {

    @GetMapping(path = "/")
    public ModelAndView showHelloWorldPage() {
        return new ModelAndView("helloworld");
    }

}



