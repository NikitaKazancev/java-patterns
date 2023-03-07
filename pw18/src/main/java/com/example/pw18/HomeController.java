package com.example.pw18;

import com.example.pw18.users.Role;
import com.example.pw18.users.auth.AuthenticationService;
import com.example.pw18.users.auth.RegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home")
@Slf4j
public class HomeController {
	public HomeController(AuthenticationService authenticationService) {
		authenticationService.register(
				RegisterRequest.builder()
						.email("admin@ya.ru")
						.password("admin")
						.firstname("admin")
						.lastname("admin")
						.build()
				, Role.ADMIN);
	}

	@GetMapping
	public ModelAndView render() {
		log.info("Render hello.html");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello.html");
		return modelAndView;
	}
}
