package sig.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Homecontroller {

/**
 * controller affichant home
 * @return  "home"
 */

@GetMapping("/consulterHome")
public String consulterHome() {
    return "home";
}
	
	
	
}
