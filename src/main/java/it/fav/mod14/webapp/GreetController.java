package it.fav.mod14.webapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetController {
	@Value("${spring.application.name}")
	private String name;
	
	@GetMapping("/")
	public String homePage(Model model) {
		return "home";
	}
	
	@PostMapping("/greet")
	public String greetPage(Model model, @RequestParam(name = "name") String name) {
		Greeter greeter = new Greeter();
		model.addAttribute("greet", greeter.greet(name));
		return "greet";
	}
}
