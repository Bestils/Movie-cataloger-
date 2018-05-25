package pl.kubie.catalogue.Controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Gladus on 25.05.2018.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String home(Model model){
        model.addAttribute("nick", "Jan");
        return "home";

    }
}
