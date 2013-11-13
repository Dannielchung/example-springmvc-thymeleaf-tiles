package nz.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LandingController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String register(final Model model) {

        model.addAttribute("body", "Landing page body");
        model.addAttribute("footer", "Footer body");

        return "Landing";
    }
}
